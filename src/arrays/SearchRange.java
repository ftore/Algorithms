package arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        int[] result = {-1, -1};

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if(target > nums[mid]) {
                lo = mid + 1;
            } else if(target < nums[mid]) {
                hi = mid - 1;
            } else {
                int left = mid;
                int right = mid;

                while(nums[left] == target && left > 0) left--;
                while(nums[right] == target && right < nums.length - 1) right++;
                result[0] = left + 1;
                result[1] = right - 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;

        int[] result = searchRange(nums, target);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
