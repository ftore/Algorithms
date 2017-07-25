package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e068529 on 7/19/17.
 */
public class SubsetsSizeK {
    public static List<List<Integer>> getSubsets(List<Integer> A, int K) {
        List<List<Integer>> result = new ArrayList<>();

        getSubsets(A, K, new ArrayList<>(), 0, result);

        return result;
    }

    public static void getSubsets(List<Integer> A, int K, List<Integer> curr, int start, List<List<Integer>> result) {
        if(start == K) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < A.size(); ++i) {
            curr.add(A.get(i));

            // put next at start + 1 location
            getSubsets(A, K, curr, start + 1, result);

            curr.remove(curr.size() - 1);
        }
        // current is excluded, replace it with next
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int K = 2;
        List<List<Integer>> result = getSubsets(A, K);

        for(List<Integer> r : result) {
            for(Integer i : r) {
                System.out.print(i + " | ");
            }
            System.out.println();
        }
    }
}
