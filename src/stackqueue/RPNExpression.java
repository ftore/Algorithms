package stackqueue;

import java.util.*;
import java.util.Stack;

/**
 * Created by e068529 on 7/12/17.
 */
public class RPNExpression {
    public static Long evaluate(String rpn) {
        if(!rpn.contains(",")) {
            return Long.parseLong(rpn);
        }
        Stack<Long> numbers = new Stack<>();


        String[] strings = rpn.split(",");
        for(int i = 0; i < strings.length; i++) {
           if(!"+-/*".contains(strings[i])) {
               numbers.push(Long.parseLong(strings[i]));
           } else {

               Long B = numbers.pop();
               Long A = numbers.pop();
               Long result = null;

               if (strings[i].equals("+")) {
                   result = A + B;
               } else if (strings[i].equals("-")) {
                   result = A - B;
               } else if (strings[i].equals("*")) {
                   result = A * B;
               } else if (strings[i].equals("/")) {
                   result = A / B;
               }
               numbers.push(result);


           }
        }

        return numbers.pop();
    }

    public static void main(String[] args) {
        String rpn = "3,4,+,2,*,1,+";
        String rpn2 = "1729";
        String rpn3 = "1,1,+,-2,*";
        String rpn4 = "-641,6,/,28,/";
        long result = evaluate(rpn);
        long result2 = evaluate(rpn2);
        long result3 = evaluate(rpn3);
        long result4 = evaluate(rpn4);


        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
