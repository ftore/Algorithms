package datastructures.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickUnion {
	
	private int[] id;
	private int count;
	
	public QuickUnion(int N) {
		id = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		
		if (rootP == rootQ) return;
		
		id[rootP] = rootQ;
		count--;
	}
	
	public int root(int p) {
		while(p != id[p]) {
			p = id[p];
		}
		
		return p;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = null;
		try {
			//in = new Scanner(new File("tinyUF.txt"));
			in = new Scanner(new File("mediumUF.txt"));
			//in = new Scanner(new File("largeUF.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int N = in.nextInt();
		QuickUnion qu = new QuickUnion(N);
		
		for(int i = 0; i < N; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			
			if(qu.connected(p, q)) continue;
			qu.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(qu.count() + " compunents");

	}

}
