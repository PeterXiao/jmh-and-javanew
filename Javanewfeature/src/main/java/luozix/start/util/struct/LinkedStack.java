/**
 * Project Name:java11_in_action File Name:LinkedStack.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:26:24 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: LinkedStack.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:26:24
 * @version V1.0
 */
package luozix.start.util.struct;

import java.util.Iterator;

/**
 * ClassName:LinkedStack <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:26:24 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: LinkedStack @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:26:24
 * @version
 * @since JDK 1.8
 */
public class LinkedStack<Item> implements Iterable<Item> {

  private Node mFirstNode;
  private int mSize;

  /**
   * Return if stack has no element
   *
   * @return true if stack is empty; otherwise false
   */
  public boolean isEmpty() {
    return mFirstNode == null;
    // or return mSize == 0;
  }

  /**
   * Get size of stack
   *
   * @return size of stack
   */
  public int size() {
    return mSize;
  }

  /**
   * Add item to top of the stack
   *
   * @param item item to be added
   */
  public void push(Item item) {
    // create temp node to store old first node
    Node oldFirstNode = mFirstNode;
    // create a new node to be first node
    mFirstNode = new Node();
    // make first node to point new item
    mFirstNode.mItem = item;
    // make old first node to be the second node
    mFirstNode.mNext = oldFirstNode;
    // increase size
    mSize++;
  }

  /**
   * Remove item from top of the stack
   *
   * @return top item
   */
  public Item pop() {
    // Get item from top of stack
    Item item = mFirstNode.mItem;
    // make the second node to be the first node
    mFirstNode = mFirstNode.mNext;
    // decrease size
    mSize--;
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkStackIterator();
  }

  private class LinkStackIterator implements Iterator<Item> {

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
