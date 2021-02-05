/**  
* @Title: BoundedBuffer.java
* @Package luozix.start.exams.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:59:56
* @version V1.0  
*/
package luozix.start.exams.concurrent;

/**
* @ClassName: BoundedBuffer
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:59:56
*
*/
class BoundedBuffer {
//	final Lock lock = new ReentrantLock();
//	final Condition notFull = lock.newCondition();
//	final Condition notEmpty = lock.newCondition();
//	final Object[] items = new Object[100];
//	int putptr, takeptr, count;
//
//	public void put(Object x) throws InterruptedException {
//		lock.lock();
//		try {
//			while (count == items.length)
//				notFull.await();
//			items[putptr] = x;
//			if (++putptr == items.length)
//				putptr = 0;
//			++count;
//			notEmpty.signal();
//		} finally {
//			lock.unlock();
//		}
//	}
//
//	public Object take() throws InterruptedException {
//		lock.lock();
//		try {
//			while (count == 0)
//				notEmpty.await();
//			Object x = items[takeptr];
//			if (++takeptr == items.length)
//				takeptr = 0;
//			--count;
//			notFull.signal();
//			return x;
//		} finally {
//			lock.unlock();
//		}
//	}
}
