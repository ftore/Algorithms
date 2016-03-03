package dynamicprogramming;

public class Fibonacci {
	// O(2^n) Exponential time
	public static long fibonacciRecursive(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	// O(n) time and space
	public static long fibonacciDP(int n) {
		long[] memo = new long[n + 1];
		
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		
		return memo[n];
	}
	
	// O(n) time and O(1) space
	public static long fibonacciUltimate(int n) {
		long back2 = 0, back1 = 1;
		long next;
		
		if(n == 0) return 0;
		
		for(int i = 2; i < n; i++) {
			next = back1 + back2;
			back2 = back1;
			back1 = next;
		}
		
		return back2 + back1;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(40));
		System.out.println(fibonacciUltimate(50));
	}
}
