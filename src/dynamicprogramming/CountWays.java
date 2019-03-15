package dynamicprogramming;

/**
 * Created by e068529 on 8/3/17.
 */
public class CountWays {
    public static int countWays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return countWays(n - 1) + countWays(n - 2);
    }
}
