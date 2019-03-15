package bits;

/**
 * Created by e068529 on 9/11/17.
 */
public class PossibleSubsets {
    public static void possibleSubsets(char[] A) {
        int N = A.length;

        for(int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if((i & (1 << j)) > 0) {
                    System.out.print(A[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] A = {'a', 'b', 'c'};

        possibleSubsets(A);
    }
}
