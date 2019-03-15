package programcreek.classic;

public class StringToInteger {
    public static int atoi(String number) {
        boolean minus = false;

        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '-') {
                minus = true;
                continue;
            }

            result = result * 10 + (number.charAt(i) - '0');
        }

        return minus ? -1 * result : result;
    }

    public static void main(String[] args) {
        String str = "-123";
        System.out.println(atoi(str));
    }
}
