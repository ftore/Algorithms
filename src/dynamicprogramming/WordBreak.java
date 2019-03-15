package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by e068529 on 8/25/17.
 */
public class WordBreak {
    public static boolean wordBreak(String str, Set<String> dictionary) {
        int n = str.length();

        if(n == 0) return true;

        for(int i = 1; i < n; i++) {
            String prefix = str.substring(0, i);

            if(dictionary.contains(prefix) && wordBreak(str.substring(i), dictionary)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreakDP(String s, Set<String> wordsSet) {
        boolean[] pos = new boolean[s.length() + 1];
        pos[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != false) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordsSet.contains(sub)) {
                        pos[j] = true;
                    }
                }
            }
        }

        return pos[s.length()] != false;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        String[] words = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
        dictionary.addAll(Arrays.asList(words));

        System.out.println(wordBreak("ilikesamsung", dictionary));
    }
}
