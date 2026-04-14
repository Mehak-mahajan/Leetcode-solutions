class Solution {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[(i + 1)]) {
                count++;
            }
        }
        // as it is circular array last point comes to first
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        if (count > 1) {
            return false;
        }

        return true;

    }

}