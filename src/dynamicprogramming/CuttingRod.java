package dynamicprogramming;

/**
 * Created by e068529 on 8/7/17.
 */
public class CuttingRod {
    public static int cutRod(int[] values, int n) {
        if(n <= 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for(int i = 0; i < n; i++) {
            max = Math.max(max, values[i] + cutRod(values, n - i - 1));
        }

        return max;
    }

    public static int cutRodDP(int price[],int n)  {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }


    public static void main(String[] args) {
        int[] values = {1, 5, 8, 9};
        System.out.println(cutRod(values, values.length));
    }
}
