package arrays;

public class DeleteDuplicates {

    // {1} -> {1}
    // {1, 2} -> {1, 2}
    // {1, 1} -> {1, 0}
    // {1, 1, 1} -> {1, 0, 0}
    public static void deleteDups(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return;

        int writeIndex = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[writeIndex - 1]) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }

        for(int i = writeIndex; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,5,7,11,11,11,13};

        deleteDups(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
