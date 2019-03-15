package dynamicprogramming;

/**
 * Created by e068529 on 8/4/17.
 */
public class StringInterleaving {
    public static boolean isInterleaved(String A, String B, String C) {
        if(A == null && B == null && C == null) return true;
        if(A.length() + B.length() != C.length()) return false;

        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];

        dp[0][0] = true;

        // populating first column
        for(int i = 1; i <= A.length(); i++) {
            if(A.charAt(i - 1) != C.charAt(i - 1)) {
                dp[i][0] = false;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

        }

        // populate first row
        for(int i = 1; i <= B.length(); i++) {
            if(B.charAt(i - 1) != C.charAt(i - 1)) {
                dp[0][i] = false;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                // Current char of C is equal to char of A but not char of B
                if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }

                // Current char of C is equal to char of B but not char of A
                else if(A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }

                // Current char of C is equal to both char of A and B
                else if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String[] args) {
        String A = "bbca";
        String B = "bcc";
        String C = "bbcbcac";

        System.out.println(isInterleaved(A, B, C));
    }
}
