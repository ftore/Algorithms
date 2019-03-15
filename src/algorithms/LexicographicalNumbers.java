package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        Comparator<Integer> lexicalComparator = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = String.valueOf(i1) + String.valueOf(i2);
                String s2 = String.valueOf(i2) + String.valueOf(i1);

                return s1.compareTo(s2);
            }
        };

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            result.add(i);
        }

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {

    }
}
