package strings;

import java.util.Scanner;

/**
 * Created by e068529 on 6/19/17.
 */
public class StringRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();

        if(isSubstring(A.substring(A.length() - 2), B.substring(0, B.length() - 2))) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    private static boolean isSubstring(String a, String b) {
        return a.contains(b);
    }
}
