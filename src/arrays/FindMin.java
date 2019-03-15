package arrays;

public class FindMin {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] > nums[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return Math.min(nums[lo], nums[hi]);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};

        System.out.println(findMin(nums));
    }
}
