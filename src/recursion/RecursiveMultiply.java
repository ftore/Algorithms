package recursion;

/**
 * Created by e068529 on 8/9/17.
 */
public class RecursiveMultiply {
    public static long muliply(int n, int x) {
        if(x == 0 || n == 0) return 0;
        if(x == 1) return n;

        return n + muliply(n, x - 1);
    }

    public static void main(String[] args) {
        int X = 5;
        int Y = 2;

        System.out.println(muliply(X, Y));
    }
}
