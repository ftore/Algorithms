package programcreek.classic;

public class MergeSortedArrays {
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int x = 0;
        while (i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                result[x] = a[i];
                i++;
            } else {
                result[x] = b[j];
                j++;
            }
            x++;
        }

        while (i < a.length) {
            result[x] = a[i];
            i++;
            x++;
        }

        while (j < b.length) {
            result[x] = b[j];
            j++;
            x++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 10};
        int[] b = {3, 6, 7, 8, 9};

        int[] result = merge(a, b);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
