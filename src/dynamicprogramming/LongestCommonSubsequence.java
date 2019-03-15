package dynamicprogramming;

/**
 * Created by e068529 on 8/7/17.
 */
public class LongestCommonSubsequence {
    public static int LCS( char[] X, char[] Y, int m, int n ) {
        // terminating condition of the recursion
        if (m == 0 || n == 0)
            return 0;

        // compare last character of strings
        if (X[m-1] == Y[n-1])
            return 1 + LCS(X, Y, m-1, n-1);
        else
            return Math.max(LCS(X, Y, m, n-1), LCS(X, Y, m-1, n));
    }

    public static int LCSMemo(char[] X, char[] Y, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        int[][] memo = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if(X[i - 1] == Y[j - 1]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        String str1 = "AAACCGTGAGTTATTCGTTCTAGAA";
        String str2 = "CACCCCTAAGGTACCTTTGGTTC";
        //System.out.println(LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
        System.out.println(LCSMemo(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
    }
}
