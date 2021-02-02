# Java11 Examples

This repository contains some new feature code after Java8, which runs on top of JDK 11.

- [var](src/main/java/io/github/biezhi/java11/var)
- [string](src/main/java/io/github/biezhi/java11/string)
- [collections](src/main/java/io/github/biezhi/java11/collections)
- [interface](src/main/java/io/github/biezhi/java11/interfaces)
- [http](src/main/java/io/github/biezhi/java11/http)
- [processor](src/main/java/io/github/biezhi/java11/processor)
- [try with resources](src/main/java/io/github/biezhi/java11/trywithresources)
- [files](src/main/java/io/github/biezhi/java11/files)
- [time](src/main/java/io/github/biezhi/java11/time)
- [single file](src/main/java/io/github/biezhi/java11/singlefile)

# License

[MIT](LICENSE)

单元测试/接口测试关注
模块接口测试

　　通过所测模块的数据流进行测试。调用所测模块时的输入参数与模块的形式参数的个数、属性和顺序是否匹配。 

局部数据结构测试

　　局部数据结构是为了保证临时存储在模块内的数据在程序执行过程中完整、正确、模块的局部数据结构往往是错误的根源。 

路径测试

　　对模块中重要的执行路径进行测试。 

错误处理测试 

　　比较完善的模块设计要求能遇见出错的条件，并设置适当的出错处理，以便在一旦程序出错时，能对出错程序重做安排，保证其逻辑上的正确性。 

边界条件测试 

　　软件经常在便捷上失效，边界条件测试是一项基础测试，也是后面系统测试中的功能测试的重点。 


细节，魔鬼在细节