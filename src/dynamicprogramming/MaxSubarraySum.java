package dynamicprogramming;

/**
 * Created by e068529 on 8/4/17.
 */
public class MaxSubarraySum {
    public int maxSubarraySumNaive(int[] A) {
        int maxSum = 0;
        int tempSum = 0;

        for(int i = 0; i < A.length; i++) {
            tempSum = A[i];

            for(int j = i + 1; j < A.length; j++) {

                tempSum += A[j];

                if (maxSum < tempSum) {
                    maxSum = tempSum;
                }
            }
        }

        return maxSum;
    }

    public int maxSubarraySumDP(int[] A) {
        int maxSumSoFar = 0;
        int maxSumCurr = 0;

        for(int i = 0; i < A.length; i++) {
            maxSumCurr = maxSumCurr + A[i];

            if(maxSumCurr < 0) {
                maxSumCurr = 0;
            }

            if(maxSumSoFar < maxSumCurr) {
                maxSumSoFar = maxSumCurr;
            }
        }

        return maxSumSoFar;
    }
}
