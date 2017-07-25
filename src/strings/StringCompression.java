package strings;

import java.util.Scanner;

/**
 * Created by e068529 on 6/19/17.
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();

        System.out.println(compress(A));
    }

    private static String compress(String A) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for(int i = 1; i < A.length(); i++) {
            char a = A.charAt(i - 1);
            char c = A.charAt(i);

            if(c != a) {
                sb.append(a);
                sb.append(count);
                count = 1;
            } else {
                count++;
            }

            if(i == A.length() - 1) {
                sb.append(a);
                sb.append(count);
            }
        }

        return sb.length() < A.length() ? sb.toString() : A;
    }
}
