import java.util.*;

public class LRU<K extends String,V>{

	DLLNode<K,V> head;
	DLLNode<K,V> tail;
	HashMap<K, DLLNode<K,V>> map;
	int capacity;


	private class DLLNode<K,V> {
		DLLNode<K,V> next;
		DLLNode<K,V> prev;
		V val;
		K key;
		int refKey;
		int refVal;

		DLLNode(K key, V val){
			this.next = null;
			this.prev = null;
			this.val  = val;
			this.key = key;
		}

		DLLNode(int key, int val){
			this.next = null;
			this.prev = null;
			this.refVal = val;
			this.refKey = key;
		}
	}


	private void add(DLLNode node){
		DLLNode headNext = this.head.next;
		this.head.next = node;
		node.prev = this.head;
		node.next = headNext;
		headNext.prev = node;
	}

	private void remove(DLLNode node){
		DLLNode next = node.next;
		DLLNode prev = node.prev;
		next.prev = prev;
		prev.next = next;
	} 

	/*
		generic constructor
	*/
	public LRU(int capacity){
		this.map = new HashMap<>();
		this.capacity = capacity;
		this.head = new DLLNode<K,V>(-1,-1);
		this.tail = new DLLNode<K,V>(-1,-1);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/*
		put key, val to cache
	*/
	public void put(K key, V val){
		if(map.containsKey(key)){
			remove(map.get(key));
		}

		DLLNode<K,V> toInsert = new DLLNode<K,V>(key, val);
		add(toInsert);
		this.map.put(key, toInsert);
        if(this.capacity < this.map.size()){
            // remove from the head
            DLLNode toRemove = this.tail.prev;
            remove(toRemove);
            this.map.remove(toRemove.key);
        }
	}


	/*
		get key, from cache
	*/
	public V get(K key){
		if(map.containsKey(key)){
			DLLNode toReturn = map.get(key);
			remove(toReturn);
			add(toReturn);
			return (V)toReturn.val;
		}

		return null;
	}


	public static void main(String [] args){
		LRU<String, Employee> cache = new LRU<String, Employee>(2);
		Employee emp1 = new Employee("Shashwat","9611832660",27);
		Employee emp2 = new Employee("tiwari","7839321468",27);
		Employee emp3 = new Employee("maa","9454144390",60);

		cache.put("1", emp1);
		cache.put("2", emp2);
		System.out.println(cache.get("2"));
		cache.put("3", emp3);
		System.out.println(cache.get("3"));
		System.out.println(cache.get("1"));

	}

}

class Employee{

	String name;
	String contact;
	int age;

	Employee(String name, String contact, int age){
		this.age = age;
		this.name = name;
		this.contact = contact;
	}

	@Override
	public String toString(){
		return "Name: " + name
				+ ", Contact: " + contact +
				", Age: " + age;
	}
}