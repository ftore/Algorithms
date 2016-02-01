package sorting;

public class InsertionSort {
	
	/**
	 * Sedgewick version
	 * @param A
	 */
	public static void insertionSort2(int[] A) {
		for(int i = 0; i < A.length; i++) {
			for(int j = i; j > 0 && A[j] < A[j - 1]; j--) {
				swap(A, j, j - 1);
			}
		}
	}
	
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = {1, 3, 2, 5, 4, 8, 6, 7};
		//insertionSort(A);
		insertionSort2(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}

}
