package dynamicprogramming;

/**
 * Created by e068529 on 7/31/17.
 */
public class MaxSubstringLengthDigits {
    public static int maxSubstringLength(String str) {
        int sum[][] = new int[str.length()][str.length()];
        int maxLen = 0;

        // Lower diagonal is of matrix not used (i > j)
        // Filling diagonal values
        for(int i = 0; i < str.length(); i++) {
            sum[i][i] = str.charAt(i) - '0';
        }

        for(int len = 2; len < str.length(); len++) {
            // Pick i and j for current substring
            for(int i = 0; i < str.length() - len + 1; i++) {
                int j = i + len - 1;
                int k = len / 2;

                // calculate value of sum[i][j]
                sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];

                // Update if len is even, left and right sums
                // are the same and len is more than maxLen
                if(len % 2 == 0 && sum[i][j - k] == sum[(j - k + 1)][j] && len > maxLen) {
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "9430723";
        System.out.print(maxSubstringLength(str));
    }
}
