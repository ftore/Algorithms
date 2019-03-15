package arrays;

public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int lo1 = 0;
        int hi1 = matrix[0].length - 1;
        int lo2 = 0;
        int hi2 = matrix.length - 1;

        while(lo1 <= hi1) {
            int mid1 = lo1 + (hi1 - lo1) / 2;
            int mid2 = lo2 + (hi2 - lo2) / 2;

            if(target > matrix[0][mid1]) {
                lo1 = mid1 + 1;
            } else if(target < matrix[0][mid1]) {
                hi1 = mid1 - 1;
            } else if(target > matrix[mid1][mid2]) {
                lo2 = mid2 + 1;
            } else if(target < matrix[mid1][mid2]) {
                hi2 = mid2 - 1;
            } else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        System.out.println(searchMatrix(matrix, 5));
    }
}
