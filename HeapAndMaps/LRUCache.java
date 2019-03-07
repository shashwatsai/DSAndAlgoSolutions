import java.util.*;

class DLLNode{
    
    DLLNode left,right;
    int val;
    int key;
    
    public DLLNode(int key, int val){
        this.left = this.right = null;
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    
    HashMap<Integer, DLLNode> map;
    int capacity;
    DLLNode head = null;
    DLLNode tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLLNode(-1,-1);
        this.tail = new DLLNode(-1,-1);
        this.head.right = tail;
        this.tail.left = head;
        this.map = new HashMap<>();
    }
    
    private void add(DLLNode node){
        // add to the tail and remove from the head
        DLLNode prev = this.tail.left;
        node.right = this.tail;
        this.tail.left = node;
        node.left = prev;
        prev.right = node;
        
    }
    
    private void remove(DLLNode node){
        DLLNode prev = node.left;
        DLLNode next = node.right;
        
        prev.right = next;
        next.left = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLLNode toReturn = map.get(key);
            remove(toReturn);
            add(toReturn);
            return toReturn.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        // if key is in the map remove it
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        DLLNode toInsert = new DLLNode(key,value);
        add(toInsert);
        this.map.put(key,toInsert);
        // if the capacity is more than the length of map
        if(this.capacity < this.map.size()){
            // remove from the head
            DLLNode toRemove = this.head.right;
            remove(toRemove);
            this.map.remove(toRemove.key);
        }
    }

    public static void main(String [] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */