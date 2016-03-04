package datastructures.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickFind {
	private int[] id;
	private int count;
	
	public QuickFind(int N) {
		id = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int pID = id[p];
		int qID = id[q];
		
		// p and q are already in the same component
		if (pID == qID) return;
		
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public int find(int p) {
		return id[p];
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
		QuickFind qf = new QuickFind(N);
		
		for(int i = 0; i < N; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			
			if(qf.connected(p, q)) continue;
			qf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(qf.count() + " compunents");
		
	}
}
