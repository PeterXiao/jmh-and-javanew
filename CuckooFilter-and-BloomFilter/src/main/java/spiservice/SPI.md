一、SPI是什么

SPI是相对API而言的。

API指的是应用对服务调用方提供的接口，用于提供某种服务、功能，面向的是服务调用方。

SPI指的是应用对服务实现方提供的接口，用于实现某种服务、功能，面向的是服务实现方

二、SPI机制

SPI(Service Provider Interface)是JDK内置的一种服务提供发现机制。
在平时开发中我们其实已经接触到，只不过一般开发真的用不上，像jdbc、apache logging等都用到SPI机制
这些SPI的接口是由Java核心库来提供，而SPI的实现则是作为Java应用所依赖的jar包被包含进类路径（CLASSPATH）中。例如：JDBC的实现mysql就是通过maven被依赖进来。
那么问题来了，SPI的接口是Java核心库的一部分，是由引导类加载器(Bootstrap Classloader)来加载的。SPI的实现类是由系统类加载器(System ClassLoader)来加载的。
引导类加载器在加载时是无法找到SPI的实现类的，因为双亲委派模型中规定，引导类加载器BootstrapClassloader无法委派系统类加载器AppClassLoader来加载。这时候，该如何解决此问题？
线程上下文类加载由此诞生，它的出现也破坏了类加载器的双亲委派模型，使得程序可以进行逆向类加载。



关于spi的详解到此就结束了，总结下spi能带来的好处：

不需要改动源码就可以实现扩展，解耦。
实现扩展对原来的代码几乎没有侵入性。
只需要添加配置就可以实现扩展，符合开闭原则。
