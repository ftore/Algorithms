package recursion;

/**
 * Created by e068529 on 8/9/17.
 */
public class MagicIndex {
    public static boolean magicIndex(int[] A) {
        return magicIndex(A, 0);
    }

    private static boolean magicIndex(int[] A, int start) {
        if(start > A.length) return false;
        if(A[start] == start) return true;

        return magicIndex(A, start + 1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 8, 4, 9, 5};

        System.out.println(magicIndex(A));
    }
}
