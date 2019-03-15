package arrays;

import java.util.Scanner;

public class NewYearChaos {
    // Complete the minimumBribes function below.
    // 2, 1 -> 1
    // 1, 3, 2 -> 1
    // 1, 4, 2, 3 -> 2
    static void minimumBribes(int[] q) {
        if(q.length <= 1) {
            System.out.println("0");
            return;
        }
        int counter = 0;
        int curr = 0;
        for(int i = 1; i < q.length; i++) {
            if(q[i - 1] > q[i]) {
                int j = i - 1;
                //while()
                counter++;
                curr++;
                swap(q, i - 1, i);

                if(curr >= 3) {
                    System.out.println("Too chaotic");
                    return;
                }
            } else {
                curr = 0;
            }
        }

        System.out.println("" + counter);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
