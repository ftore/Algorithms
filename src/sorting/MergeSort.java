package sorting;

public class MergeSort {
	public static void mergeSort(int[] A) {
		int[] aux = new int[A.length];
		mergeSort(A, aux, 0, A.length - 1);
	}
	
	private static void mergeSort(int[] A, int[] aux, int lo, int hi) {
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(A, aux, lo, mid);
		mergeSort(A, aux, mid + 1, hi);
		merge(A, aux, lo, mid, hi);
	}
	
	private static void merge(int[] A, int[] aux, int lo, int mid, int hi) {
		// copy to aux[]
		for(int i = lo; i <= hi; i++) {
			aux[i] = A[i];
		}
		
		// merge back to A[]
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) {
				A[k] = aux[j++];
			} else if(j > hi) {
				A[k] = aux[i++];
			} else if(aux[j] < aux[i]) {
				A[k] = aux[j++];
			} else {
				A[k] = aux[i++];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 5, 4, 8, 6, 7};
		mergeSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}
}
