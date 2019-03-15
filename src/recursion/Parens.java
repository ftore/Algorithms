package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e068529 on 8/9/17.
 */
public class Parens {
    public static void addParens(ArrayList<String> list, int left, int right, char[] str, int index) {
        // invalid state
        if(left < 0 || right < left) return;

        // Out of left and right parentheses
        if(left == 0 && right == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParens(list, left - 1, right, str, index + 1);

            str[index] = ')';
            addParens(list, left, right - 1, str, index + 1);
        }
    }

    public static List<String> generateParens(int count) {
        ArrayList<String> list = new ArrayList<>();
        int left = count;
        int right = count;
        char[] str = new char[count * 2];
        addParens(list, left, right, str, 0);

        return list;
    }

    public static void main(String[] args) {

        List<String> list = generateParens(5);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
