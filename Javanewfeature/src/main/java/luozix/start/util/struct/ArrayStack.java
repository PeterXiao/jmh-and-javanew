/**
 * Project Name:java11_in_action File Name:ArrayStack.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:28:06 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ArrayStack.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:28:06
 * @version V1.0
 */
package luozix.start.util.struct;

import java.util.Iterator;

/**
 * ClassName:ArrayStack <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:28:06 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ArrayStack @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:28:06
 * @version
 * @since JDK 1.8
 */
public class ArrayStack<Item> implements Iterable<Item> {

  private Item[] mArr = (Item[]) new Object[1];
  private int mSize = 0;

  /**
   * Resize current array to a new size
   *
   * @param newSize new size
   */
  private void resize(int newSize) {
    Item[] tempArr = (Item[]) new Object[newSize];
    System.arraycopy(mArr, 0, tempArr, 0, mSize);
    mArr = tempArr;
  }

  /**
   * Return if stack is empty.
   *
   * @return True if stack has no element. False otherwise.
   */
  public boolean isEmpty() {
    return mSize == 0;
  }

  /**
   * Return size of stack
   *
   * @return size of stack
   */
  public int size() {
    return mSize;
  }

  /**
   * Add an item to top of the stack
   *
   * @param item item to be added
   */
  public void push(Item item) {
    // extend array if necessary
    if (mSize == mArr.length) {
      resize(2 * mArr.length);
    }
    // add item
    mArr[mSize++] = item;
  }

  /** Remove the item from top of the stack */
  public Item pop() {
    // get top item
    Item item = mArr[--mSize];
    // cancel reference from array
    mArr[mSize] = null;
    // shorten array size if necessary
    if (mSize > 0 && mSize == mArr.length / 4) {
      resize(mArr.length / 2);
    }
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayStackIterator();
  }

  private class ArrayStackIterator implements Iterator<Item> {

    private int mIndex = mSize;

    @Override
    public boolean hasNext() {
      return mIndex > 0;
    }

    @Override
    public Item next() {
      return mArr[--mIndex];
    }

    @Override
    public void remove() {}
  }
}
