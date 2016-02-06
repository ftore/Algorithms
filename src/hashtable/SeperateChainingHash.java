package hashtable;

import java.util.LinkedList;
import java.util.Queue;

public class SeperateChainingHash {
	private int N; // key-value pairs
	private int M; // Hash size
	
	
	private Node[] st;
	
	private static class Node {
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SeperateChainingHash() {
		this(997);
	}
	
	public SeperateChainingHash(int size) {
		M = size;
		st = new Node[M];
	}
	
	// hash value between 0 and M - 1
	private int hash(String key) {
		return Math.abs(key.hashCode()) % M;
	}
	
	public int size() {
		return N;
	}
	
	public boolean containsKey(String key) {
		return get(key) != null;
	}
	
	public Object get(String key) {
		int i = hash(key);
		Node x = st[i];
		while(x != null) {
			if(((String)x.key).equals(key)) {
				return x.value;
			}
			x = x.next;
		}
		return null;
	}
	
	public void add(String key, Object value) {
		if(key == null) throw new IllegalArgumentException("Key cannot be null");
		int i = hash(key);
		Node x = st[i];
		// check whether key is already exists and replace it
		while(x != null) {
			if(x.key.equals(key)) {
				x.value = value;
				return;
			}
			x = x.next;
		}
		N++;
		st[i] = new Node(key, value, st[i]);
	}
	
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			Node x = st[i];
			while(x != null) {
				queue.add((String) x.key);
				x = x.next;
			}
		}
		
		return queue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeperateChainingHash st = new SeperateChainingHash(3);
		st.add("name", "Akmal");
		st.add("age", 30);
		st.add("city", "Tashkent");
		
		System.out.println(st.get("name"));
		
		Iterable<String> keys = st.keys();
		
		for(String key : keys) {
			System.out.println(key);
		}
	}

}
