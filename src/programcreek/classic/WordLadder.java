package programcreek.classic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String s1, String s2, Set<String> dict) {
        Queue<WordNode> toExplore = new LinkedList<>();

        toExplore.add(new WordNode(s1, 1));

        dict.add(s2);

        while(!toExplore.isEmpty()) {
            WordNode curr = toExplore.poll();

            if(curr.word.equals(s2)) {
                return curr.numSteps;
            }

            char[] arr = curr.word.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char tmp = arr[i];

                    if(arr[i] != c) {
                        arr[i] = c;
                    }

                    String tmpStr = new String(arr);

                    if(dict.contains(tmpStr)) {
                        toExplore.add(new WordNode(tmpStr, curr.numSteps + 1));
                        dict.remove(tmpStr);
                    }

                    arr[i] = tmp;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";

        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        System.out.println(ladderLength(start, end, dict));
    }

    private static class WordNode {
        String word;
        int numSteps;

        public WordNode(String w, int i) {
            word = w;
            numSteps = i;
        }
    }
}
