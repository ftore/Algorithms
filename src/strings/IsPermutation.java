package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by e068529 on 6/15/17.
 */
public class IsPermutation {
    public static void main(String[] args) {
        String A = "aabbcca";
        String B = "aaabcbc";
        String C = "aabccbb";

        long start = System.currentTimeMillis();
        System.out.println("A and B is " + isPermutation(A, B));

        System.out.println("A and B is " + isPermutation2(A, B));
        System.out.println("A and C is " + isPermutation(A, C));
        System.out.println("A and C is " + isPermutation2(A, C));

    }

    // by sorting
    private static boolean isPermutation(String A, String B) {
        char[] cA = A.toCharArray();
        char[] cB = B.toCharArray();

        Arrays.sort(cA);
        Arrays.sort(cB);

        for(int i = 0; i < cA.length; i++) {
            if(cA[i] != cB[i]) return false;
        }

        return true;
    }

    // by hashmap
    private static boolean isPermutation2(String A, String B) {
        Map<Character, Integer> mapA = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(mapA.containsKey(c)) {
                mapA.put(c, mapA.get(c) + 1);
            } else {
                mapA.put(c, 1);
            }
        }

        for(int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if(mapA.containsKey(c) && mapA.get(c) > 0) {
                mapA.put(c, mapA.get(c) - 1);
            } else return false;
        }

        return true;
    }
}
