package arrays;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        // always test for edge cases
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        for(int i = 0; i < matrix.length; i++) {
            int n = matrix[i].length;
            if(target <= matrix[i][n - 1]) {
                int result = binarySearch(matrix[i], target);
                if(result >= 0) return true;
            }
        }

        return false;
    }

    public static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(target > arr[mid]) {
                lo = mid + 1;
            } else if(target < arr[mid]) {
                hi = mid - 1;
            } else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1}};

        if(searchMatrix(arr, 1)) {
            System.out.println("true");
        } else System.out.println("false");
    }
}
