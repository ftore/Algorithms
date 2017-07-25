package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by e068529 on 7/19/17.
 */
public class PowerSet {
    public static Set<List<Integer>> generatePowerSet(int[] A) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        generatePowerSet(A, 0, curr, result);

        return result;
    }

    private static void generatePowerSet(int[] A, int start, List<Integer> curr,  Set<List<Integer>> result) {
        if(start == A.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(A[start]);
        generatePowerSet(A, start + 1, curr, result);

        curr.remove(curr.size() - 1);
        generatePowerSet(A, start + 1, curr, result);

    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2};

        Set<List<Integer>> result = generatePowerSet(A);

        for(List<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + " | ");
            }

            System.out.println();
        }
    }
}
