package programcreek.classic;

// Rotate an array of n elements to the right by k steps.
public class RotateArray {
    private void rotateRight(int[] arr) {
        int tmp = arr[arr.length - 1];
        for(int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = tmp;
    }

    public void rotateRight(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            rotateRight(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotateRight(arr, 3);
        rotateArray.printArray(arr);
    }

    public void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
