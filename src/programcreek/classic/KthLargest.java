package programcreek.classic;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int result = 0;
        for(int i = 0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};

        System.out.println(kthLargest(arr, 2));
    }
}
