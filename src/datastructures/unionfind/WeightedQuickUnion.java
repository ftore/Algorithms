package datastructures.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedQuickUnion {
	
	private int[] id;
	private int[] size;
	private int count;
	
	public WeightedQuickUnion(int N) {
		id = new int[N];
		size = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		
		if (rootP == rootQ) return;
		
		if(size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		
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
	
	public int size(int p) {
		return size[p];
	}
	
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("tinyUF.txt"));
			//in = new Scanner(new File("mediumUF.txt"));
			//in = new Scanner(new File("largeUF.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int N = in.nextInt();
		WeightedQuickUnion wqu = new WeightedQuickUnion(N);
		
		for(int i = 0; i < N; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			
			if(wqu.connected(p, q)) continue;
			wqu.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(wqu.count() + " compunents");

	}
}
