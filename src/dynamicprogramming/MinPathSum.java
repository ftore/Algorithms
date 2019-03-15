package dynamicprogramming;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n+1];

        for (int j = 0; j < n; j++) dp[j+1] = dp[j] + grid[0][j];

        dp[0] = Integer.MAX_VALUE;

        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                dp[j+1] = Math.min(dp[j], dp[j+1]) + grid[i][j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(arr));
    }
}
