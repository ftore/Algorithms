package dynamicprogramming;

/**
 * Created by e068529 on 8/4/17.
 */
public class EditDistance {

    private static int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), Math.min(j, k));
    }

    public static int editDistance(String str1 , String str2 , int m ,int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDistance(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDistance(str1,  str2, m, n-1),    // Insert
                editDistance(str1,  str2, m-1, n),   // Remove
                editDistance(str1,  str2, m-1, n-1) // Replace
        );
    }

    public static int editDistanceDP(String str1, String str2, int m, int n) {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                            dp[i-1][j],  // Remove
                            dp[i-1][j-1]); // Replace
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "computer";
        String str2 = "commuter";
        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));

        str1 = "saturday";
        str2 = "sunday";
        System.out.println(editDistanceDP(str1, str2, str1.length(), str2.length()));
    }
}
