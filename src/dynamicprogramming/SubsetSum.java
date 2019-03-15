package dynamicprogramming;

/**
 * Created by e068529 on 8/5/17.
 */
public class SubsetSum {
    public static boolean isSubsetSum(int[] arr, int end, int target) {
        if(target == 0) return true;

        if(end == 0 && target != 0) return false;

        // if the last element > X, ignore it
        if(arr[end - 1] > target) {
            return isSubsetSum(arr, end - 1, target);
        }

        // else check both ways
        // - excluding the last element in the sum
        // - including the last element in the sum
        return isSubsetSum(arr, end - 1, target)
                || isSubsetSum(arr, end - 1, target - arr[end - 1]);
    }

    public static boolean isSubsetSumDP(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be true if there
        // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        return subset[sum][n];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1};
        int X = 6;
        System.out.println(isSubsetSum(arr, arr.length, X));
    }
}
