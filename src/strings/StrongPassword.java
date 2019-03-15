package strings;

import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        int countNumber = 1;
        int countLower = 1;
        int countUpper = 1;
        int countSpecial = 1;
        int countLength = 1;

        if(n >= 6) countLength--;

        for(int i = 0; i < password.length(); i++) {
            String c = String.valueOf(password.charAt(i));
            if(numbers.contains(c) && countNumber > 0) {
                countNumber--;
            }

            if(lower_case.contains(c) && countLower > 0) {
                countLower--;
            }

            if(upper_case.contains(c) && countUpper > 0) {
                countUpper--;
            }

            if(special_characters.contains(c) && countSpecial > 0) {
                countSpecial--;
            }
        }

        int count = countNumber + countLower + countUpper + countSpecial;

        return count + n >= 6 ? count : 6 - n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);
        System.out.println(answer);
//        bufferedWriter.write(String.valueOf(answer));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
