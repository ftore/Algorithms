package sorting;

public class QuickSort {
	
	public static void quickSort(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		
		quickSort(A, lo, hi);
	}
	
	public static void quickSort(int[] A, int lo, int hi) {
		if(lo >= hi) return;
		
		int position = partition(A, lo, hi);
		
		quickSort(A, lo, position - 1);
		quickSort(A, position + 1, hi);
	}
	
	private static int partition(int[] A, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int k = A[lo];
		
		while(true) {
			// find item on lo to swap
			while(A[++i] < k) {
				if(i == hi) break;
			}
			
			// find item on hi to swap
			while(A[--j] > k) {
				if(j == lo) break;
			}
			
			if(i >= j) break;
			
			swap(A, i, j);
		}
		
		swap(A, lo, j);
		
		return j;
	}
	
	
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 5, 4, 8, 6, 7};
		quickSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}
}
