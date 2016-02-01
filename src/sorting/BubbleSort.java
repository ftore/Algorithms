package sorting;

public class BubbleSort {
	public static void bubbleSort(int[] A) {
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A.length; j++) {
				if(A[i] < A[j]) {
					swap(A, i, j);
				}
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
		bubbleSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
