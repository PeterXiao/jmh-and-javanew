Java 11 in Action
=================

Please refer https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/ first.

# Official features

* Nest-based access control
* Dynamic class-file constraints
* Improve Aarch64 Intrinsics
* Epsilon: A No-Op Garbage Collector
* Remove enterprise APIs: JAXB, JAX-WS, JAX-WS Annotations, CORBA, JTA, JAF
* JavaFX: no longer bundled with Java 11, and with OpenJFX and added as dependency
* HTTP Client (Standard)
* Local variable syntax for lambda parameters: https://blog.jetbrains.com/idea/2018/06/java-11-in-intellij-idea-2018-2/
* Key agreement with Curve25519 and Curve448
* Unicode 10 support
* Flight recorder
* ChaCha20 and Poly1305 cryptographic algorithms
* Launch single-file source-code programs
* Low-overhead heap profiling
* TLS 1.3 support
* ZGC: A scalable low-latency garbage collector (Experimental)
* Removed: Applets, Java Web Start
* Deprecate the Nashorn JavaScript Engine, replaced with Graal.js
* Deprecate the Pack200 Tools and API

# Demo

* Project Amber:

   * JEP 302 Lambda Leftovers
   * JEP 305 Pattern Matching
   * JEP 323 Local-Variable Syntax for Lambda Parameters
   * JEP 325 Switch Expressions
   * JEP 326 Raw String Literals
* Type inference
* Http Client: BodyHandlers with various useful handlers  http://openjdk.java.net/groups/net/httpclient/intro.html  https://download.java.net/java/early_access/jdk11/docs/api/java.net.http/java/net/http/HttpResponse.BodyHandlers.html
* Enhanced Enum
* data class
* Launch Single-File Source-Code Programs
```
java --source 11 src/main/java/org/mvnsearch/App.java
```

# References

* <<Java 11 Quick Start>>
* JDK 11: http://openjdk.java.net/projects/jdk/11/
* JDK 11 Download: http://jdk.java.net/11/
* Project Amber: http://openjdk.java.net/projects/amber/

10）工具-更喜欢一个成熟的技术堆栈。太多的工具通常会导致意想不到的复杂性。
9）数据所有权-为每个微服务优先使用单独的数据库或架构，以保持明确的表所有权。
8）事件搜寻-研究您是否真正需要它并仔细设计。
7）耦合-注意依赖版本和共享库（尤其是内部库）。微服务通常比我们意识到的要耦合得多。
6）自动化-使用CI / CD并使过程自动化。请记住，一切“手工制作”都会使您的基础架构复杂化。
5）失败-失败的设计。这是一个分布式的网络环境。而且，再次避免使高度耦合的微服务整体式怪兽同时失败。
4）有限责任责任-有明确的责任。将某些前端页面与某些API相关联，以便您知道发生故障时微服务负责。
3）工具-拥有一些定义明确的工具是一种优点；但是，仍然可以使用明显更好的工具。让团队使用最适合自己项目的方法。
2）设计-在公司范围内对服务进行建模，并确保管理层了解高层架构。
1）沟通-团队之间的沟通是必须的。让某人了解一切如何协同工作以及不同团队负责什么。

spring mvc 典型目录

	controller层: 控制url路由映射，request、session、response 的读取、写入
	service层: 封装了 repository 层并提供服务给 controller 层，执行业务相关的逻辑
	repository层: 封装了对数据库的调用，并处理数据库表/行和POJO之间的映射
	model/entity层: repository 层用来把数据库表/行映射的 POJO
一个 client request 过来，依次经过 controller -> service -> repository -> service -> controller（忽略web容器的TCP/HTTP处理），它们都是同步阻塞调用的，所以使用起来非常方便、易于理解和调试



