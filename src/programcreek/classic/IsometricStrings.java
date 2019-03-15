package programcreek.classic;

import java.util.HashMap;
import java.util.Map;

public class IsometricStrings {

    public static boolean isIsometric(String x, String y) {
        if(x == null && y == null)
            return false;

        if(x.length() != y.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < x.length(); i++) {
            char x1 = x.charAt(i);
            char y1 = y.charAt(i);

            if(map.containsKey(x1)) {
                if(map.get(x1) != y1) return false;
            } else {
                if(map.containsValue(y1))
                    return false;

                map.put(x1, y1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "foo";
        String s2 = "bar";

        if(isIsometric(s1, s2)) {
            System.out.println("Isometric");
        } else {
            System.out.println("NOT Isometric");
        }
    }

}
