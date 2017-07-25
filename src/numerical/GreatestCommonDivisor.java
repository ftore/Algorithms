package numerical;

/**
 * Created by e068529 on 5/9/17.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(GCD(60, 24));
    }

    // Euclid's algorithm
    // the value B decreases by at least a factor of 1/2 for every two trips through the while loop
    // time complexity is O(logB)
    public static int GCD(int A, int B) {
        while (B != 0) {
            int remainder = A % B;
            A = B;
            B = remainder;
        }

        return A;
    }
}
