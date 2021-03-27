OpenJDK 11.0.9 builds with Shenandoah GC

Now with OpenJDK 11.0.9 out and Shenandoah GC backported I tested which OpenJDK distributions support Shenandoah GC.

The following OpenJDK distributions support Shenandoah GC:

AdoptOpenJDK 11.1

Amazon Coretto

Azul Zulu CE

The following OpenJDK distributions do not support Shenandoah GC:

AdoptOpenJDK 11

BellSoft Liberica JDK

OpenJDK project upstream guilds

SAP SapMachine

I could not yet test 11.0.9 builds for the following distributions:

Alibaba Dragonwell

RedHat

Edit

AdoptOpenJDK put out a 11.1 release with Shenandoah


https://github.com/ScoopInstaller/Java



1.Oracle JDK
Oracle官方的商业JDK，收费。

2.Oracle OpenJDK
Oracle官方的商业JDK的社区版，免费。

3.Amazon Corretto
Amazon Corretto 是亚马逊基于 开放Java 开发工具包 (OpenJDK) 的免费、多平台、生产就绪型发行版。Corretto 提供长期支持，其中包括性能增强和安全修复。亚马逊在内部的数千种生产服务上运行 Corretto，并且 Corretto 已被证明能够兼容 Java SE 标准。借助 Corretto，您可以在常用操作系统（包括 Linux、Windows 和 macOS）上开发和运行 Java 应用程序。

4.BellSoft Liberica JDK
OpenJDK 的贡献者之一 BellSoft发布的基于OpenJDK的免费版。

5.AdoptOpenJDK
现属于Eclipse基金会的基于OpenJDK发布的免费版本，支持Oracle公司的HotSpot虚拟机和Eclipse基金会的OpenJ9虚拟机。

6.Azul Zulu OpenJDK
Azul 成立于 2002 年，是一家私营软件公司，总部位于加州桑尼维尔，在全球设有销售、技术支持和工程办事处，基于OpenJDK发布，免费。

7.SAP SapMachine
SAP是OpenJDK项目的贡献者之一，基于OpenJDK发布，免费。

8.Red Hat build of OpenJDK
Red Hat(红帽子)公司基于OpenJDK发布的免费版。

9.阿里巴巴Dragonwell JDK
Alibaba Dragonwell 是一款免费的, 生产就绪型Open JDK 发行版，提供长期支持，包括性能增强和安全修复。阿里巴巴拥有最丰富的Java应用场景，覆盖电商，金融，物流等众多领域，世界上最大的Java用户之一。Alibaba Dragonwell作为Java应用的基石，支撑了阿里经济体内所有的Java业务。Alibaba Dragonwell完全兼容 Java SE 标准，您可以在任何常用操作系统（包括 Linux、Windows 和 macOS）上开发 Java 应用程序， 运行时生产环境选择Alibaba Dragonwell。

10.腾讯Kona JDK
腾讯 Kona（Tencent Kona，TK）是免费、可立即投入生产的 OpenJDK 发行版。腾讯 Kona 基于 TencentJDK 开发，针对云应用场景定制新的功能及优化， 具备更快的云应用启动速度，更好的性能以及更为便捷的分析、诊断工具；此外，腾讯 Kona 服务于腾讯内部大量 Java 应用程序，提供稳定、高效的运行环境。 

11.华为毕昇JDK
华为内部OpenJDK定制版的开源版本，是一个高性能、可用于生产环境的OpenJDK发行版。

Corretto
Amazon
Amazon Corretto is a no-cost, multiplatform, production-ready distribution of the Open Java Development Kit (OpenJDK). Corretto comes with long-term support that will include performance enhancements and security fixes. Amazon runs Corretto internally on thousands of production services and Corretto is certified as compatible with the Java SE standard. With Corretto, you can develop and run Java applications on popular operating systems, including Linux, Windows, and macOS.

$ sdk install java x.y.z-amzn
GraalVM
Oracle
GraalVM is a universal virtual machine for running applications written in JavaScript, Python, Ruby, R, JVM-based languages like Java, Scala, Groovy, Kotlin, Clojure, and LLVM-based languages such as C and C++. GraalVM removes the isolation between programming languages and enables interoperability in a shared runtime. It can run either standalone or in the context of OpenJDK, Node.js or Oracle Database.

$ sdk install java x.y.z-grl
Liberica
Bellsoft
Liberica is a 100% open-source Java implementation. It is built from OpenJDK which BellSoft contributes to, is thoroughly tested and passed the JCK provided under the license from OpenJDK. All supported versions of Liberica also contain JavaFX 12.

$ sdk install java x.y.z-librca
OpenJDK
AdoptOpenJDK
AdoptOpenJDK.net started in 2017 following years of discussions about the general lack of an open and reproducible build and test system for OpenJDK source across multiple platforms. AdoptOpenJDK provides rock-solid OpenJDK binaries for the Java ecosystem and also provides infrastructure as code, and a Build farm for builders of OpenJDK, on any platform.

$ sdk install java x.y.z-adpt
OpenJDK
jdk.java.net
OpenJDK (Open Java Development Kit) is a free and open-source implementation of the Java Platform, Standard Edition (Java SE). It is the result of an effort Sun Microsystems began in 2006. The implementation is licensed under the GNU General Public License (GNU GPL) version 2 with a linking exception. Were it not for the GPL linking exception, components that linked to the Java class library would be subject to the terms of the GPL license. OpenJDK is the official reference implementation of Java SE since version 7.

$ sdk install java x.y.z-open
SapMachine
SAP
SAP SE is a German multinational software corporation that makes enterprise software to manage business operations and customer relations. SAP is headquartered in Walldorf, Baden-Württemberg, Germany with regional offices in 180 countries. SapMachine is a downstream version of the OpenJDK project. It is used to build and maintain a SAP supported version of OpenJDK for SAP customers and partners who wish to use OpenJDK to run their applications. SAP is committed to ensuring the continued success of the Java platform.

$ sdk install java x.y.z-sapmchn
Zulu
Azul Systems
Azul Systems serves companies who need to deliver server-based Java applications for their web-facing customers (travel, online retail, gaming, SaaS), meet specific latency targets for real-time business systems (advertising networks, capital markets, communications) ensure timely maintenance or security updates for essential applications, or deliver Java-based systems for embedded and IoT use cases.

$ sdk install java x.y.z-zulu