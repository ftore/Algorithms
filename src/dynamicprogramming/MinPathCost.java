package dynamicprogramming;

/**
 * Created by e068529 on 8/3/17.
 */
public class MinPathCost {

    public static int minPathCostRecustion(int[][] cost, int m, int n) {
        if(m == 0 && n == 0) return cost[0][0];
        // In first row
        if(m == 0) {
            return minPathCostRecustion(cost, m, n - 1) + cost[0][n];
        }

        // In first column
        if(n == 0) {
            return minPathCostRecustion(cost, m - 1, n) + cost[m][0];
        }

        int x = minPathCostRecustion(cost, m, n - 1);
        int y = minPathCostRecustion(cost, m - 1, n);

        return Math.min(x, y) + cost[m][n];
    }

    public static int minPathCostDP(int[][] cost, int m, int n) {
        int[][] memo = new int[m][n];
        return minPathCostDP(cost, memo, m, n);
    }

    private static int minPathCostDP(int[][] cost, int[][] memo, int m, int n) {
        if(memo[m][n] != 0) return memo[m][n];

        if(m == 0 && n == 0) {
            memo[m][n] = cost[0][0];
        } else if(m == 0) {
            memo[m][n] = minPathCostDP(cost, memo, m, n - 1) + cost[0][n];
        } else if(n == 0) {
            memo[m][n] = minPathCostDP(cost, memo, m - 1, n) + cost[m][0];
        } else {
            int x = minPathCostDP(cost, memo, m - 1, n);
            int y = minPathCostDP(cost, memo, m, n - 1);

            memo[m][n] = Math.min(x, y) + cost[m][n];
        }

        return memo[m][n];
    }
}
