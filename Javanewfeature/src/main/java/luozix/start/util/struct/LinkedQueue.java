/**
 * Project Name:java11_in_action File Name:LinkedQueue.java Package Name:luozix.start.util.struct
 * Date:2021年3月4日下午3:29:03 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: LinkedQueue.java @Package luozix.start.util.struct @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:29:02
 * @version V1.0
 */
package luozix.start.util.struct;
/**
 * ClassName:LinkedQueue <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午3:29:03 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.Iterator;

/**
 * @ClassName: LinkedQueue @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午3:29:03
 * @version
 * @since JDK 1.8
 */
public class LinkedQueue<Item> implements Iterable<Item> {

  private Node mFirstNode;
  private Node mLastNode;
  private int mSize;

  /**
   * Return is queue has no element
   *
   * @return true if is empty; false otherwise
   */
  public boolean isEmpty() {
    return mFirstNode == null;
    // or return mSize == 0;
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
   * Add an item into queue's tail
   *
   * @param item item to be added
   */
  public void enqueue(Item item) {
    // create temp node to store old last node
    Node oldLastNode = mLastNode;
    // create new node to be last node
    mLastNode = new Node();
    // store item in new last node
    mLastNode.mItem = item;
    // make new last node's next to be null as it's the last
    mLastNode.mNext = null;
    if (isEmpty()) {
      // if queue is empty, then first is the last
      mFirstNode = mLastNode;
    } else {
      // if queue is not empty, then make old last node's next to be new last node
      oldLastNode.mNext = mLastNode;
    }
    // increase size
    mSize++;
  }

  /**
   * Remove first item from queue's head
   *
   * @return first item
   */
  public Item dequeue() {
    // get item from first node
    Item item = mFirstNode.mItem;
    // make second node to be first node
    mFirstNode = mFirstNode.mNext;
    if (isEmpty()) {
      // if queue is empty, make last node as null
      mLastNode = null;
    }
    // decrease size
    mSize--;
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkQueueIterator();
  }

  private class LinkQueueIterator implements Iterator<Item> {

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
