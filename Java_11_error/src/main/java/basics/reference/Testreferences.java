/**
 * 
 */
package basics.reference;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

//import org.junit.Test;

/**
 * @author Office
 *
 */
public class Testreferences {
	@Test  
	public void strongReference() {  
	    Object referent = new Object();  
	      
	    /** 
	     * 通过赋值创建 StrongReference  
	     */  
	    Object strongReference = referent;  
	      
	    assertSame(referent, strongReference);  
	      
	    referent = null;  
	    System.gc();  
	      
	    /** 
	     * StrongReference 在 GC 后不会被回收 
	     */  
	    assertNotNull(strongReference);  
	}
	
	
	 @Test  
	 public void weakReference() {  
	     Object referent = new Object();  
	     WeakReference<Object> weakRerference = new WeakReference<Object>(referent);  
	   
	     assertSame(referent, weakRerference.get());  
	       
	     referent = null;  
	     System.gc();  
	       
	     /** 
	      * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收 
	      */  
	     assertNull(weakRerference.get());  
	 }
	 
	 @Test  
	 public void weakHashMap() throws InterruptedException {  
	     Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();  
	     Object key = new Object();  
	     Object value = new Object();  
	     weakHashMap.put(key, value);  
	   
	     assertTrue(weakHashMap.containsValue(value));  
	       
	     key = null;  
	     System.gc();  
	       
	     /** 
	      * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理 
	      */  
	     Thread.sleep(1000);  
	       
	     /** 
	      * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry 
	      */  
	     assertFalse(weakHashMap.containsValue(value));  
	 }
	 
	 @Test  //SoftReference 于 WeakReference 的特性基本一致， 最大的区别在于 SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证), 这一特性使得 SoftReference 非常适合缓存应用
	 public void softReference() {  
	     Object referent = new Object();  
	     SoftReference<Object> softRerference = new SoftReference<Object>(referent);  
	   
	     assertNotNull(softRerference.get());  
	       
	     referent = null;  
	     System.gc();  
	       
	     /** 
	      *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用 
	      */  
	     assertNotNull(softRerference.get());  
	 }
	 
	 @Test  //最关键的来了， Phantom Reference(幽灵引用) 与 WeakReference 和 SoftReference 有很大的不同, 因为它的 get() 方法永远返回 null, 这也正是它名字的由来
	 //PhantomReference 唯一的用处就是跟踪 referent 何时被 enqueue 到 ReferenceQueue 中.
	 public void phantomReferenceAlwaysNull() {  
	     Object referent = new Object();  
	     PhantomReference<Object> phantomReference = new PhantomReference<Object>(referent, new ReferenceQueue<Object>());  
	       
	     /** 
	      * phantom reference 的 get 方法永远返回 null  
	      */  
	     assertNull(phantomReference.get());  
	 }
	 
	 @Test  
	 public void referenceQueue() throws InterruptedException {  
	     Object referent = new Object();       
	     ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();  
	     WeakReference<Object> weakReference = new WeakReference<Object>(referent, referenceQueue);  
	       
	     assertFalse(weakReference.isEnqueued());  
	     Reference<? extends Object> polled = referenceQueue.poll();  
	     assertNull(polled);  
	       
	     referent = null;  
	     System.gc();  
	   
	     assertTrue(weakReference.isEnqueued());  
	     Reference<? extends Object> removed = referenceQueue.remove();  
	     assertNotNull(removed);  
	 }
	/* PhantomReference 有两个好处， 其一， 它可以让我们准确地知道对象何时被从内存中删除， 这个特性可以被用于一些特殊的需求中(例如 Distributed GC， XWork 和 google-guice 中也使用 PhantomReference 做了一些清理性工作).

	 其二， 它可以避免 finalization 带来的一些根本性问题, 上文提到 PhantomReference 的唯一作用就是跟踪 referent 何时被 enqueue 到 ReferenceQueue 中, 但是 WeakReference 也有对应的功能, 两者的区别到底在哪呢 ?
	 这就要说到 Object 的 finalize 方法, 此方法将在 gc 执行前被调用, 如果某个对象重载了 finalize 方法并故意在方法内创建本身的强引用, 这将导致这一轮的 GC 无法回收这个对象并有可能
	 引起任意次 GC， 最后的结果就是明明 JVM 内有很多 Garbage 却 OutOfMemory， 使用 PhantomReference 就可以避免这个问题， 因为 PhantomReference 是在 finalize 方法执行后回收的，也就意味着此时已经不可能拿到原来的引用, 也就不会出现上述问题, 当然这是一个很极端的例子, 一般不会出现.*/
}
