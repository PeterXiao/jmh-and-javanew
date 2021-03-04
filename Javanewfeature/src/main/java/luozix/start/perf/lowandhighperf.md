



1.Presizing collections
2.Using Singleton
3.Reusing exceptions
4.Pool management
5.Using thread locals
6.Using weak references
7.Using primitive type collections
8.Enumerating constants
9.Flyweight pattern
10.Using chars instead of Strings
11.Lazy initialization

Every point will be presented in the form:
How we usually do
How we should do to achieve no GC and trade offs
Measurement results"
I would like to create comprehensive checklist for Java low latency application. Can you add your checklist here?

Here is my list
1. Make your objects immutable
2. Try to reduce synchronized method
3. Locking order should be well documented, and handled carefully
4. Use profiler
5. Use Amdhal's law, and find the sequential execution path
6. Use Java 5 concurrency utilities, and locks
7. Avoid Thread priorities as they are platform dependent
8. JVM warmup can be used
9. Prefer unfair locking strategy
10. Avoid context-switching (many threads lead to counter productive)
11. Avoid boxing, un-boxing
12. Give attention to compiler warnings
13. Number of threads should be equal or lesser than the number of core

Low-latency application is tuned for every milli-seconds.
https://logging.apache.org/log4j/2.x/manual/async.html


Warm up your JVM. Bytecode starts starts off being interpreted for Hotspot and then gets compiled on the server after 10K observations. Tiered Compilation can be a good stop gap.

Classloading is a sequential process that involves IO to disk. Make sure all the classes for your main transaction flows are loaded upfront and that they never get evicted from the perm generation.

Follow the "Single Writer Principle" to avoid contention and the queueing effect implications of Little's Law, plus study Amdhal's Law for what can be parallel and is it worth it.

Model you business domain and ensure all your algorithms are O(1) or at least O(log n). This is probably the biggest cause of performance issues in my experience. Make sure you have performance tests to cover the main cases.

Low-latency in Java is not just limited to Java. You need to understand the whole stack your code is executing on. This will involve OS tuning, selecting appropriate hardware, tuning systems software and device drivers for that hardware.

Be realistic. If you need low-latency don't run on a hypervisor. Ensure you have sufficient cores for all threads that need to be in the runnable state.

Cache misses are your biggest cost to performance. Use algorithms that are cache friendly and set affinity to processor cores either with taskset or numactl for a JVM or JNI for individual threads.

Consider an alternative JVM like Zing from Azul with a pause-less garbage collector.

Most importantly get someone involved with experience. This will save you so much time in the long run. Shameless plug :-)

Real-time and low-latency are distinctly separate subjects although often related. Real-time is about being more predictable than fast. In my experience the real-time JVMs, even the soft real-time ones, are slower than the normal JVMs.

There are a bunch of things to be aware of yes. I'm in Crete at the moment with limited net access so this will be (fairly) short. Also, I'm not a low-latency expert, but several of my colleagues play one in real life :-).

You need to appreciate Mechanical Sympathy (a term coined by Martin Thompson). In other words you need to understand what your underlying hardware is doing. Knowing how CPUs load cache lines, what their read/write bandwidth is, speed of main memory and much, much more is very important. Why? Because you'll need to reason how your Java source code affects the OperatingSystem/Hardware via the runtime JVM. For example, is the way your field variables are laid out in your source code causing cache line evictions (costs you ~150 clock cycles), hmmm... :-).

Generally you want lock free algorithms and I/O. Even the most well designed concurrent application (that uses locks) is at risk of blocking, blocking in low latency is generally bad :-).

Understand Object Allocation and Garbage Collection. This is a massive topic, but basically you want to avoid GC pauses (often caused by the Stop the World nature of various GC collections). Specialist GC collectors like the Azul collector can in many cases solve this problem for you out of the box, but for most people they need to understand how to tune the Sun/Oracle GCs (CMS, G1, etc).

The Hotspot JIT is freaking amazing. Learn about its optimizations, but generally speaking all of the good OO techniques (encapsulation, small methods, as much immutable data as possible) will allow JIT to optimize, giving you the sorts of performance levels that well crafted C/C++ code gives you.

Overall system architecture. Be aware of the network, how machines are co-located, if you're connected to the exchange via fiber etc etc.

Be aware of the impact of logging. logging binary or using coded output that you can parse off line is probably a good idea.

Overall I highly recommend going on Kirk Pepperdine's Java Performance Tuning course [Disclaimer: I teach this course myself, so I'm biased]. You'll get good coverage of the various aspects of the JVM and its impact on underlying O/S and hardware.

PS: I'll try to revisit this later and tidy it up some.

Share