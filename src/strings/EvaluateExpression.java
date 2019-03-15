package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by e068529 on 8/17/17.
 */
public class EvaluateExpression {
    public static long evaluateExpressions(String[] expressions) {
        Map<String, String> keyMap = new HashMap<>();
        Stack<Integer> numsStack = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i = 0; i < expressions.length; i++) {

        }

        return 0;
    }

    public static void main(String[] args) {
        String str1 = "dinner = eat + drink + 2";
        String str2 = "eat = 2 + 5";
        String str3 = "drink = 3 * 1";
        String[] expression = {str1, str2, str3};

        long result = evaluateExpressions(expression);
        System.out.print(result);
    }
}
