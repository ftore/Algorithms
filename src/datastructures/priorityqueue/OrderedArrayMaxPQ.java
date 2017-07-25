package datastructures.priorityqueue;

public class OrderedArrayMaxPQ {
	
	private Integer[] pq; // elements
	private int N;        // number of elements
	
	public OrderedArrayMaxPQ(int capacity) {
		pq = new Integer[capacity];
		N = 0;
	}
	
	public boolean isEmpty()      { return N == 0; }
	public int size()             { return N; }
	public Integer delMax()       { return pq[--N]; }
	
	public void insert(Integer x) {
		int i = N - 1;
		while(i >= 0 && x < pq[i]) {
			pq[i + 1] = pq[i];
			i--;
		}
		pq[i + 1] = x;
		N++;
	}
	
	public static void main(String[] args) {
		OrderedArrayMaxPQ pq = new OrderedArrayMaxPQ(10);
		pq.insert(10);
		pq.insert(1);
		pq.insert(5);
		pq.insert(3);
		pq.insert(8);
		pq.insert(6);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.delMax());
		}
	}

}
