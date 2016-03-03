package algorithms.sorting;

public class SelectionSort {
	
	public static void selectionSort(int[] A) {
		for(int i = 0; i < A.length; i++) {
			int min = i;
			for(int j = i + 1; j < A.length; j++) {
				if(A[j] < A[min]) {
					min = j;
				}
			}
			swap(A, i, min);
		}
	}
	
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = {1, 3, 2, 5, 4, 8, 6, 7};
		selectionSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}

}
