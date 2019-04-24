package multithreading;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArraySort {
    static class SortTask extends RecursiveAction {
        final int[] array;
        final int lo, hi;
        static final int THRESHOLD = 10;

        SortTask(int[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        protected void compute() {
            if (hi - lo < THRESHOLD) {
                System.out.println("Sorting array sequentially");
                sortSequentially(lo, hi);
            } else {
                System.out.println("Sorting array in parallel");
                int mid = (lo + hi) / 2;

                invokeAll(new SortTask(array, lo, mid),
                        new SortTask(array, mid, hi));

                merge(lo, mid, hi);
            }
        }

        // implementation details follow:
        void sortSequentially(int lo, int hi) {
            Arrays.sort(array, lo, hi);
        }

        void merge(int lo, int mid, int hi) {
            System.out.println("Merging array.");
            int[] buf = Arrays.copyOfRange(array, lo, mid);
            for (int i = 0, j = lo, k = mid; i < buf.length; j++)
                array[j] = (k == hi || buf[i] < array[k]) ?
                        buf[i++] : array[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int lo = 0;
        int hi = arr.length - 1;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new SortTask(arr, lo, hi));
    }
}
