package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArraySum {
    private static class ASum extends RecursiveAction {
        int[] A; // input array
        int LO, HI; // subrange
        int SUM; // return value

        public ASum(int[] arr, int lo, int hi) {
            this.A = arr;
            this.LO = lo;
            this.HI = hi;
        }

        @Override
        protected void compute() {
            if(LO == HI) {
                SUM += A[LO];
            } else if(LO > HI) {
                SUM = 0;
            } else {
                int mid = (this.LO + this.HI) / 2;
                ASum left = new ASum(A, LO, mid);
                ASum right = new ASum(A, mid + 1, HI);
                left.compute();
                right.compute();
                SUM = left.SUM + right.SUM;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int lo = 0;
        int hi = arr.length - 1;
        ASum aSum = new ASum(arr, lo, hi);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(aSum);

        System.out.println(aSum.SUM);
    }
}
