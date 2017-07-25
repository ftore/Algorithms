package algorithms.shuffle;

/**
 * Knuth shuffle algorithm
 * 
 * @author Akmal
 *
 */
public class Shuffle {
	public static void shuffle(int[] A) {
		int N = A.length;
		
		for(int i = 0; i < N; i++) {
			int r = i + (int) (Math.random() * (N - i));
			int tmp = A[r];
			A[r] = A[i];
			A[i] = tmp;
		}
	}
}
