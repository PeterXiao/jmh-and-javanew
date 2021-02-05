guava的loadingcache什么时候删除过期的数据？

错误答案一：根据过期策略，过期了就删除

错误答案二：过期的数据gc回收的时候，就会删除
这个也是不对的，gc只是对weakKeys或者weakValues的情况下才有用，否则是gc是没影响的。

正确答案一： cleanUp的时候会删除过期数据

cleanUp方法会清除所有segment的过期数据：

正确答案二：put操作的时候，会cleanUp当前segment的数据


