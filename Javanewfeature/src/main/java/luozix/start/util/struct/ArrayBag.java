/**
 * Project Name:java11_in_action File Name:ArrayBag.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:27:01 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ArrayBag.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:27:01
 * @version V1.0
 */
package luozix.start.util.struct;

import java.util.Iterator;

/**
 * ClassName:ArrayBag <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:27:01 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ArrayBag @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:27:01
 * @version
 * @since JDK 1.8
 */
public class ArrayBag<Item> implements Iterable<Item> {

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
   * Return if bag has no element
   *
   * @return true if size is empty; false otherwise
   */
  public boolean isEmpty() {
    return mSize == 0;
  }

  /**
   * Return size of bag
   *
   * @return size of bag
   */
  public int size() {
    return mSize;
  }

  public void add(Item item) {
    if (mSize == mArr.length) {
      resize(2 * mArr.length);
    }
    mArr[mSize++] = item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayBagIterator();
  }

  private class ArrayBagIterator implements Iterator<Item> {

    private int mIndex = 0;

    @Override
    public boolean hasNext() {
      return mIndex < mSize;
    }

    @Override
    public Item next() {
      return mArr[mIndex++];
    }

    @Override
    public void remove() {}
  }
}
