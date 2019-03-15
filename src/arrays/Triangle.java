package arrays;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        triangle.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        triangle.add(new ArrayList<>(list));

        list = new ArrayList<>();
        list.add(1);
        list.add(-1);
        list.add(-3);
        triangle.add(new ArrayList<>(list));

        System.out.println(minimumTotal(triangle));
    }
}
