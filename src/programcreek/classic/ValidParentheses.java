package programcreek.classic;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(c == ')') {
                char cc = stack.pop();
                if(cc != '(') return false;
            } else if(c == ']') {
                char cc = stack.pop();
                if(cc != '[') return false;
            } else if(c == '}') {
                char cc = stack.pop();
                if(cc != '{') return false;
            }
        }

        return true;
    }
}
