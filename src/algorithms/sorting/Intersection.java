package algorithms.sorting;

import java.util.*;

public class Intersection {
    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> map = new HashSet<>();

        for(int i = 0; i < arr1.length; i++) {
            if(!map.contains(arr1[i])) {
                map.add(arr1[i]);
            }
        }

        for(int i = 0; i < arr2.length; i++) {
            if(map.contains(arr2[i])) {
                result.add(arr2[i]);
                map.remove(arr2[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,3, 5, 5, 6, 7, 7,8,12};
        int[] arr2 = {5,5,6,8,8,9,10,10};

        List<Integer> result = intersection(arr1, arr2);
        for(Integer i : result) {
            System.out.println(i);
        }
    }
}
