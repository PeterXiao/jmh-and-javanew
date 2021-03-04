/**
 * Project Name:java11_in_action File Name:ArrayQueue.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:27:32 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ArrayQueue.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:27:32
 * @version V1.0
 */
package luozix.start.util.struct;

import java.util.Iterator;

/**
 * ClassName:ArrayQueue <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:27:32 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ArrayQueue @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:27:32
 * @version
 * @since JDK 1.8
 */
public class ArrayQueue<Item> implements Iterable<Item> {

  private Item[] mArr = (Item[]) new Object[1];
  private int mSize = 0;

  private void resize(int newSize) {
    Item[] tempArr = (Item[]) new Object[newSize];
    System.arraycopy(mArr, 0, tempArr, 0, mSize);
    mArr = tempArr;
  }

  /**
   * Return if the queue has no element
   *
   * @return true if is empty; false otherwise
   */
  public boolean isEmpty() {
    return mSize == 0;
  }

  /**
   * Return size of queue
   *
   * @return size of queue
   */
  public int size() {
    return mSize;
  }

  /**
   * Add item to queue tail
   *
   * @param item item to be added
   */
  public void enqueue(Item item) {
    if (mSize == mArr.length) {
      resize(2 * mArr.length);
    }
    mArr[mSize++] = item;
  }

  /**
   * Remove item in queue's head
   *
   * @return item removed
   */
  public Item dequeue() {
    if (!isEmpty()) {
      // get head item
      Item item = mArr[0];
      mSize--;
      // move items position
      Item[] tempArr = (Item[]) new Object[mArr.length - 1];
      System.arraycopy(mArr, 1, tempArr, 0, tempArr.length);
      mArr = tempArr;
      // shorten array size if necessary
      //	            if (mSize > 0 && mSize == mArr.length / 4) {
      //	                resize(mArr.length / 2);
      //	            }
      return item;
    } else {
      return null;
    }
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayQueueIterator();
  }

  private class ArrayQueueIterator implements Iterator<Item> {

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public Item next() {
      return null;
    }

    @Override
    public void remove() {}
  }
}
