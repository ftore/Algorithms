package arrays;

public class RemoveDups2 {
    public static int removeDuplicates(int[] nums) {
        int dup = 0;
        int numArr = nums.length;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i]) {
                dup++;
                if(dup >= 3) {
                    moveLeftOne(nums, i);
                    numArr--;
                    dup = 0;
                }
            }
        }

        return numArr;
    }

    public static void moveLeftOne(int[] nums, int i) {
        for(int x = i + 1; x < nums.length; x++) {
            nums[x - 1] = nums[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};

        removeDuplicates(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
