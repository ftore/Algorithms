package dynamicprogramming;

/**
 * Created by e068529 on 8/7/17.
 */
public class CoinChange {
    public static int minCoins(int[] coins, int S) {
        // terminating condition
        if(S == 0) {
            return 0;
        }

        // init result
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            // try every coin that has value S
            if(coins[i] <= S) {
                int tmp = minCoins(coins, S - coins[i]);
                if(tmp + 1 < result) {
                    result = tmp + 1;
                }
            }
        }

        return result;
    }

    public static int minCoinsDP(int[] coins, int S) {
        // create memo
        int[] memo = new int[S + 1];

        memo[0] = 0;

        // init all values to infinite
        for(int i = 1; i <= S; i++) {
            memo[i] = Integer.MAX_VALUE;
        }

        // compute values buttom up
        for(int i = 1; i <= S; i++) {
            // go through all coins < i
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int tmp = memo[i - coins[j]];

                    if(tmp != Integer.MAX_VALUE && tmp + 1 < memo[i]) {
                        memo[i] = tmp + 1;
                    }
                }
            }
        }


        return memo[S];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int S = 4;

        System.out.print(minCoins(coins, S));
    }
}
