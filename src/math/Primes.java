package math;

import java.util.Arrays;

/**
 * A number is prime if it is only divisible by 1 and itself. 
 * So for example 2, 3, 5, 79, 311 and 1931 are all prime numbers...
 * 
 * @author Akmal
 *
 */
public class Primes {
	
	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	private static boolean isPrime2(int n) {
		if(n <= 1) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		int m = (int) Math.sqrt(n);
		
		for(int i = 3; i <= m; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean[] sieve(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		
		int m = (int) Math.sqrt(n);
		
		for(int i = 2; i <= m; i++) {
			if(prime[i]) {
				for(int k = i * i; k <= n; k += i) {
					prime[k] = false;
				}
			}
		}
		
		return prime;
	}
	
	/**
	 * The greatest common divisor (GCD) of two numbers a and b is the greatest 
	 * number that divides evenly into both a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int GCD(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		
		for(int i = Math.min(a, b); i >= 1; i--) {
			if(a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return -1;
	}
	
	// better way, Euclid's algorithm
	public static int GCD2(int a, int b) {
		if(b == 0) return a;
		return GCD2(b, a % b);
	}
	
	// lowest common multiple (LCM)
	public static int LCM(int a, int b) {
		return b * a / GCD2(a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
