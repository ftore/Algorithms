package strings;

import java.util.Stack;

public class RemoveTreeConsecutive {
    public static String remove3ConsecutiveDuplicates(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            stack.push(c);

            if(stack.size() > 2) {
                char el1 = stack.pop();
                char el2 = stack.pop();
                char el3 = stack.pop();

                if(el1 == el2 && el2 == el3) continue;
                else {
                    stack.push(el3);
                    stack.push(el2);
                    stack.push(el1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static String removeConsecutive(String s, int minRepeatsToRemove) {
        int pos = 0;
        StringBuilder sb = new StringBuilder();

        while (pos < s.length()) {
            char c = s.charAt(pos);
            int repeats = 1;
            while (pos + repeats < s.length() && c == s.charAt(pos + repeats))
                repeats++;

            if (repeats < minRepeatsToRemove)
                for (int i = 0; i < repeats; i++)
                    sb.append(c);

            pos += repeats;
        }

        return sb.toString();
    }

    public static void main (String[] args) {
        String str = "aabbbaccddddc";

        String str2 = remove3ConsecutiveDuplicates(str);
        System.out.println(str2);
    }
}
