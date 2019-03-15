package arrays;

public class IncrementInteger {

    // {9, 9, 9} -> {1, 0, 0, 0}
    // {1, 2, 9} -> {1, 3, 0}
    // {9} -> {1, 0}
    public static int[] incrementInteger(int[] arr) {
        int compliment = 1;
        int last = arr.length - 1;
        for(int i = last; i >= 0; i--) {
            if(arr[i] + compliment < 10) {
                arr[i] = arr[i] + compliment;
                compliment = 0;
            }
            else {
                int j = arr[i] + compliment;
                arr[i] = j % 10;
                compliment = 1;
            }
        }

        if(compliment > 0) {
            arr = resizeOne(arr);
            arr[0] = compliment;
        }

        return arr;
    }

    public static int[] resizeOne(int[] arr) {
        int[] newArr = new int[arr.length + 1];

        for(int i = arr.length - 1, j = newArr.length - 1; i >= 0; i--, j--) {
            newArr[j] = arr[i];
        }

        return newArr;
    }


    public static void main(String[] args) {
        int[] arr = {9, 9, 8};

        arr = incrementInteger(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
