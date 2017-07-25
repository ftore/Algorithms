package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by e068529 on 6/15/17.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        A = A.toLowerCase();

        if(isPalindrome(A)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    private static boolean isPalindrome(String A) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == ' ') continue;

            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int odd = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 != 0) odd++;

            if(odd > 1) return false;
        }

        return true;
    }
}
