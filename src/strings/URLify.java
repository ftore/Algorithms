package strings;

import java.util.Scanner;

/**
 * Created by e068529 on 6/15/17.
 */
public class URLify {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        char[] A = str.toCharArray();
        for(int i = 0; i < A.length; i++) {
            if(A[i] == ' ') {
                for(int j = 0; j < 2; j++) {
                    moveRightByOne(A, ++i);
                }
            }
        }

        fill(A);

        System.out.print(A);
    }

    private static void moveRightByOne(char[] arr, int position) {
        //System.arraycopy(arr, position, arr, position + 1, arr.length);
        if(position <= 0) return;

        char tmp, prev;
        prev = arr[position - 1];

        for(int i = position; i < arr.length; i++) {
            tmp = arr[i];
            arr[i] = prev;
            prev = tmp;
        }
    }

    private static void fill(char[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                arr[i++] = '%';
                arr[i++] = '2';
                arr[i++] = '0';
            }
        }
    }
}
