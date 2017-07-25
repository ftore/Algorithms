package algorithms.searching;

public class BinarySearch {
	
	public static int binarySearch(int[] A, int val) {
		int lo = 0;
		int hi = A.length - 1;
		
		
		while(hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			
			if(val > A[mid]) {
				lo = mid + 1;
			} else if(val < A[mid]) {
				hi = mid - 1;
			} else return mid;
		}
		
		return -1;
	}
	
}
