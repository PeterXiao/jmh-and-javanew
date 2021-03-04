/**
 * Project Name:java11_in_action File Name:LinkedBag.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:28:37 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: LinkedBag.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:28:37
 * @version V1.0
 */
package luozix.start.util.struct;

import java.util.Iterator;

/**
 * ClassName:LinkedBag <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:28:37 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: LinkedBag @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:28:37
 * @version
 * @since JDK 1.8
 */
public class LinkedBag<Item> implements Iterable<Item> {

  private Node mFirstNode;
  private int mSize;

  /**
   * Return if the bag has no element
   *
   * @return true if empty; false otherwise
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

  /**
   * Add item into bag
   *
   * @param item item to be added
   */
  public void add(Item item) {
    Node oldFirstNode = mFirstNode;
    mFirstNode = new Node();
    mFirstNode.mItem = item;
    mFirstNode.mNext = oldFirstNode;
    mSize++;
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkBagIterator();
  }

  private class LinkBagIterator implements Iterator<Item> {

    private Node mCurrentNode = mFirstNode;

    @Override
    public boolean hasNext() {
      return mCurrentNode != null;
    }

    @Override
    public Item next() {
      // get item in current node
      Item item = mCurrentNode.mItem;
      // make next node to be current node
      mCurrentNode = mCurrentNode.mNext;
      // return item in current node
      return item;
    }

    @Override
    public void remove() {}
  }

  /** Node element in linked list */
  private class Node {
    Item mItem;
    Node mNext;
  }
}
