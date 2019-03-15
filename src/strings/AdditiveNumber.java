package strings;

/**
 * Created by e068529 on 8/27/17.
 */
public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;

        String prev, curr, next;

        for(int i = 0; i < num.length(); i++) {
            prev = String.valueOf(num.charAt(i));

            int j = i + 1;
            while(num.charAt(j) == '0' && j < num.length()) {
                prev += '0';
                j++;
            }
            i = j;

            curr = String.valueOf(num.charAt(i));

            int k = j + 1;
            while(num.charAt(k) == '0' && k < num.length()) {
                curr += '0';
                k++;
            }

            i = k;
            next = String.valueOf(num.charAt(i));

            if(Integer.valueOf(prev) + Integer.valueOf(curr) != Integer.valueOf(next)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "199100199";
        System.out.print(isAdditiveNumber(s));

    }
}
