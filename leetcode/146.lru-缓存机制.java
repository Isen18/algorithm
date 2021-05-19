import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
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
  
        //存在
        visitExistNode(node);
  
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            //存在
            node.value = value;
            visitExistNode(node);
            return;
        }
  
        //不存在
        node = new Node(key, value);
        headInsertNode(node);
  
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

    //访问存在的节点
    private void visitExistNode(Node node) {
        removeNode(node);
        headInsertNode(node);
    }

    private void removeNode(Node node) {
        if (node == tail) {
            //尾节点
            tail = node.pre;
            tail.next = null;
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
  
    private void headInsertNode(Node node) {
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end