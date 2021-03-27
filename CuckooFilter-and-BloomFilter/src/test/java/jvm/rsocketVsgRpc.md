# RSocket 与 gRPC性能对比

几乎每次我向观众介绍RSocket时，都会有人问这个问题：“ RSocket与gRPC相比如何？”

今天我们要找出答案。

搭建平台
插座
RSocket在应用程序网络上实现反应式语义。它是一种网络协议，可端对端实施反压力和其他反应流概念。

gRPC
gRPC旨在解决多语言RPC问题。它包含两个部分：protobuf IDL和HTTP / 2网络协议。

苹果到苹果？
从设计和组件上，我们知道苹果与苹果的比较应该是RSocket与HTTP / 2。

但是，您将如何有效地比较两种协议？一种方法是使用相同的应用程序对它们进行基准测试。为了使应用程序在协议上运行，我们需要一个RPC SDK。 

RSocket在编码器上是不可知的。它支持JSON，protobuf和其他定义。在此基准测试中，我们将RSocket与protobuf，Java RPC和Messagepack一起使用。对于gRPC，我们仅会使用protobuf，因为事实证明它已经是gRPC的最佳性能编码器。

语境
在进行基准测试之前，让我们先比较两种协议的用例。基本上，RSocket是为应用程序通信而设计的，而HTTP / 2仍是为处理Web流量而设计的。

但是“旨在处理网络流量”是什么意思？好吧，这意味着客户端和服务器之间有明显的区别。会话样式主要是请求/响应，并且可能存在流。请记住，TCP并不强调客户端/服务器的区别。当我们使用HTTP / 2协议时，服务器很难向客户端发出反向请求，更不用说使用相同的套接字连接了。

另一方面，应用程序之间的通信则完全不同。应用程序是具有对话的同级。谁是服务器和谁是客户端之间没有强硬的界限，尤其是在微服务架构中。

为了涵盖大多数对话场景，RSocket实现了四种类型的通信模型：

Request/response (stream of 1)
Request/stream (finite stream of many)
Fire-and-forget (no response)
Channel (bi-directional streams)
RSocket不仅是多路复用的，而且发送方和接收方可以在保留相同的套接字连接的同时切换角色。

基准测试
建立
两台服务器，每台服务器均带有2.50GHz + 8G @ 4核Intel®Xeon®Platinum 8163 CPU
JVM配置

 -Xmx2g -Xms2g -XX：+ AlwaysPreTouch -XX：+ UseStringDeduplication

gRPC配置

gRPC windowupdate = 1 * 1024 * 1024 * 1024
抽样规则

10次​​尝试中最好的结果
工具

我们使用的软件包是Netifi开发的比较工具 。它是一个Java堆栈。

堆与直接

在一些结果中，我们将看到堆与直接比较。它主要用于高负载的Java应用程序。在图表上，我们将显示堆（带有 _h  标签）和非堆（带有 _d 标签）结果。

结果：
两个有意义的基准是吞吐量（QPS）和延迟。以下是不同负载下的结果：

100,000-request_32-concurrency_16-conns_16bytes-repsonse

中央处理器

我们还针对10,000,000-request_512​​-concurrency_16-conns_16bytes-repsonse测试测试了CPU使用率 。使用Java分析工具，我们得到以下结果：

图片标题

 

结论
很明显，在Java版本中，RSocket SDK胜过gRPC。在QPS，延迟，CPU消耗和可伸缩性方面，RSocket在每个类别中的性能均优于gRPC。

反应性gRPC？
我们应该问的最后一个问题是：“当gRPC进行反应时会发生什么？” 为了回答这个问题，我推荐Oleh Dokuka和Igor Lozynskyi撰写的《Spring 5中的动手响应式编程》一书。Oleh Dokuka是反应式gRPC项目的主要贡献者之一。在这本书中，有一章比较了反应式gRPC与RSocket。我引用：“唯一的区别是它支持更高粒度的流控制。由于gRPC是在HTTP / 2之上构建的，因此该框架将HTTP / 2流量控制作为构建块来提供细粒度的反压控制。但是，流量控制仍然依赖于滑动窗口的大小（以字节为单位），因此，逻辑单元级别粒度上的反压控制没有被发现。”

因此，基本上，HTTP / 2不能“真正地”响应，即使使用响应式实现，gRPC的性能也可以提高很多。

