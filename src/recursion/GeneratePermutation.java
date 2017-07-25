package recursion;

import java.util.*;

/**
 * Created by e068529 on 7/17/17.
 */
public class GeneratePermutation {
    public static List<int[]> permutations(int[] A) {
        List<int[]> result = new ArrayList<>();
        permutation(A, 0, result);
        return result;
    }

    public static void permutation(int[] A, int start, List<int[]> result){
        if(start >= A.length) {
            result.add(A.clone());
        } else {
            for (int i = start; i < A.length; i++) {
                swap(A, start, i);
                permutation(A, start + 1, result);
                //swap(A, start, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};

        List<int[]> result = permutations(A);

        for(int[] r : result) {
            for (Integer i : r) {
                System.out.print(i + " | ");
            }
            System.out.println();
        }

//        permutation("", "ABC");
//
//        Set<String> dictionary = new HashSet<>();
//        dictionary.add("BAC");
//        if(isAnagram("", "ABC", dictionary)) {
//            System.out.println("ABC has anagrams.");
//        }

    }

    private static void permutation(String soFar, String rest) {
        if(rest.equals("")) {
            System.out.println(soFar);
        } else {
            for (int i = 0; i < rest.length(); i++) {
                String next = soFar + rest.charAt(i);
                String remaining = rest.substring(0, i) + rest.substring(i + 1);
                permutation(next, remaining);
            }
        }
    }

    private static boolean isAnagram(String soFar, String rest, Set<String> dictionary) {
        if(rest.equals("")) {
            if(dictionary.contains(soFar)) return true;
        } else {
            for(int i = 0; i < rest.length(); i++) {
                String next = soFar + rest.charAt(i);
                String remaining = rest.substring(0, i) + rest.substring(i + 1);

                if(isAnagram(next, remaining, dictionary)) return true;
            }
        }
        return false;
    }
}
