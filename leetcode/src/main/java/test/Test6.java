package test;

import java.util.HashMap;
import java.util.Map;

public class Test6 {

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    lruCache.get(1);
    lruCache.put(3, 3);
    lruCache.get(2);
    lruCache.put(4, 4);
    lruCache.get(1);
    lruCache.get(3);
    lruCache.get(4);
  }
}

class LRUCache {
  private static class Node {
      private int key;
      private int value;
      private Node pre;
      private Node next;

      private Node(){}

      private Node(int key, int value) {
          this.key = key;
          this.value = value;
      }
  }

  private Node head;
  private Node tail;
  private int size;
  private int capacity;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<>(capacity);
      this.head = new Node();
      this.tail = this.head;
      this.size = 0;
  }
  
  public int get(int key) {
      Node node = map.get(key);
      if (node == null) {
          //不存在
          return -1;
      }

      if (node == tail) {
          //尾节点
          tail = node.pre;
          tail.next = null;
      } else {
          node.pre.next = node.next;
          node.next.pre = node.pre;
      }

      insertHead(node);

      return node.value;
  }
  
  public void put(int key, int value) {
      Node node = map.get(key);
      if (node != null) {
          //存在
          node.value = value;
          get(key);
          return;
      }

      //不存在
      node = new Node(key, value);
      insertHead(node);

      map.put(key, node);
      size++;

      if (size > capacity) {
          node = tail;
          tail = tail.pre;
          tail.next = null;
          map.remove(node.key);
          size--;
      }
  }

  private void insertHead(Node node) {
      if (head == tail) {
          node.pre = head;
          head.next = node;
          tail = node;
          return;
      }

      node.next = head.next;
      head.next.pre = node;
      node.pre = head;
      head.next = node;
  }
}