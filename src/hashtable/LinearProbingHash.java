package hashtable;

import javax.sound.sampled.Line;
import javax.swing.text.AbstractDocument.LeafElement;

class HashEntry {
	private String key;
	private int value;
	
	public HashEntry(String k, int v) {
		key = k;
		value = v;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

public class LinearProbingHash {
	
	private HashEntry[] entryTable;
	private static int TABLE_SIZE = 128;
	
	public LinearProbingHash() {
		entryTable = new HashEntry[TABLE_SIZE];
		for(int i = 0; i < TABLE_SIZE; i++) {
			entryTable[i] = null;
		}
	}
	
	public LinearProbingHash(int size) {
		TABLE_SIZE = size;
		new LinearProbingHash();
	}
	
	public int hash(String key) {
		return Math.abs(key.hashCode()) % TABLE_SIZE;
	}
	
	public void add(String key, int value) {
		int index = hash(key);
		while(entryTable[index] != null && entryTable[index].getKey() != key) {
			index++;
		}
		entryTable[index] = new HashEntry(key, value);
	}
	
	public int get(String key) {
		int index = hash(key);
		while(entryTable[index] != null && entryTable[index].getKey() != key) {
			index++;
		}
		
		if(entryTable[index] == null) {
			return -1;
		} else {
			return entryTable[index].getValue();
		}
	}
	
	public static void main(String[] args) {
		LinearProbingHash hashMap = new LinearProbingHash();
		hashMap.add("Akmal", 1);
		hashMap.add("Baha", 2);
		
		System.out.println(hashMap.get("Baha"));
		System.out.println(hashMap.get("Akmal"));
	}
}
