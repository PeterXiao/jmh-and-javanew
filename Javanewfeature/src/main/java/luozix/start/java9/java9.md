Java 9 改进的 Stream API 添加了一些便利的方法，使流处理更容易，并使用收集器编写复杂的查询。

Java 9 为 Stream 新增了几个方法：dropWhile、takeWhile、ofNullable，为 iterate 方法新增了一个重载方法。

takeWhile 方法
语法

default Stream<T> takeWhile(Predicate<? super T> predicate)
takeWhile() 方法使用一个断言作为参数，返回给定 Stream 的子集直到断言语句第一次返回 false。如果第一个值不满足断言条件，将返回一个空的 Stream。

takeWhile() 方法在有序的 Stream 中，takeWhile 返回从开头开始的尽量多的元素；在无序的 Stream 中，takeWhile 返回从开头开始的符合 Predicate 要求的元素的子集。



dropWhile 方法
语法

default Stream<T> dropWhile(Predicate<? super T> predicate)
dropWhile 方法和 takeWhile 作用相反的，使用一个断言作为参数，直到断言语句第一次返回 false 才返回给定 Stream 的子集。


iterate 方法
语法

static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
方法允许使用初始种子值创建顺序（可能是无限）流，并迭代应用指定的下一个方法。 当指定的 hasNext 的 predicate 返回 false 时，迭代停止。


ofNullable 方法
语法

static <T> Stream<T> ofNullable(T t)
ofNullable 方法可以预防 NullPointerExceptions 异常， 可以通过检查流来避免 null 值。

如果指定元素为非 null，则获取一个元素并生成单个元素流，元素为 null 则返回一个空流。

Java 9 改进的 CompletableFuture API
Java 9 新特性 Java 9 新特性

Java 8 引入了 CompletableFuture<T> 类，可能是 java.util.concurrent.Future<T> 明确的完成版（设置了它的值和状态），也可能被用作java.util.concurrent.CompleteStage 。支持 future 完成时触发一些依赖的函数和动作。Java 9 引入了一些CompletableFuture 的改进：

Java 9 对 CompletableFuture 做了改进：

支持 delays 和 timeouts
提升了对子类化的支持
新的工厂方法
支持 delays 和 timeouts
public CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit)
在 timeout（单位在 java.util.concurrent.Timeunits units 中，比如 MILLISECONDS ）前以给定的 value 完成这个 CompletableFutrue。返回这个 CompletableFutrue。

public CompletableFuture<T> orTimeout(long timeout, TimeUnit unit)
如果没有在给定的 timeout 内完成，就以 java.util.concurrent.TimeoutException 完成这个 CompletableFutrue，并返回这个 CompletableFutrue。

增强了对子类化的支持
做了许多改进使得 CompletableFuture 可以被更简单的继承。比如，你也许想重写新的 public Executor defaultExecutor() 方法来代替默认的 executor。

另一个新的使子类化更容易的方法是：

public <U> CompletableFuture<U> newIncompleteFuture()
新的工厂方法
Java 8引入了 <U> CompletableFuture<U> completedFuture(U value) 工厂方法来返回一个已经以给定 value 完成了的 CompletableFuture。Java 9以 一个新的 <U> CompletableFuture<U> failedFuture(Throwable ex) 来补充了这个方法，可以返回一个以给定异常完成的 CompletableFuture。

除此以外，Java 9 引入了下面这对 stage-oriented 工厂方法，返回完成的或异常完成的 completion stages:

<U> CompletionStage<U> completedStage(U value): 返回一个新的以指定 value 完成的CompletionStage ，并且只支持 CompletionStage 里的接口。
<U> CompletionStage<U> failedStage(Throwable ex): 返回一个新的以指定异常完成的CompletionStage ，并且只支持 CompletionStage 里的接口。
