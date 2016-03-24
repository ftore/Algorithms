package datastructures.priorityqueue;

public class UnorderedArrayMaxPQ {
	private Integer[] pq; // elements
	private int N;        // number of elements
	
	public UnorderedArrayMaxPQ(int capacity) {
		pq = new Integer[capacity];
		N = 0;
	}
	
	public boolean isEmpty()      { return N == 0; }
	public int size()             { return N; }
	public void insert(Integer x) { pq[N++] = x; }
	
	public Integer delMax() {
		int max = 0;
		for(int i = 1; i < N; i++) {
			if(pq[max] < pq[i]) max = i;
		}
		
		swap(max, N - 1);
		
		return pq[--N];
	}
	
	public void swap(int i, int j) {
		int tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}

	public static void main(String[] args) {
		UnorderedArrayMaxPQ pq = new UnorderedArrayMaxPQ(10);
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
