package recursion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveDigitSum {
    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 1; i < k; i++) {
//            sb.append(n);
//        }

        BigInteger P = new BigInteger(n);
        BigInteger result = P.multiply(new BigInteger(String.valueOf(k)));

        return superDigit(result.toString());

    }

    static int superDigit(String P) {
        if(P.length() == 1) return Integer.parseInt(P);

        int sum = 0;
        for(int i = 0; i < P.length(); i++) {
            sum += Character.getNumericValue(P.charAt(i));
        }

        return superDigit(String.valueOf(sum));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(result);

        scanner.close();
    }
}
