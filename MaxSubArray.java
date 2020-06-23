public class MaxSubArray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at
     * least one number) which has the largest sum and return its sum.
     * 
     * Input: [-2,1,-3,4,-1,2,1,-5,4]
     * 
     * Output: 6
     * 
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            max = Math.max(max, current);
            for (int j = i + 1; j < nums.length; j++) {
                current += nums[j];
                max = Math.max(max, current);
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], nums[i] + max[i - 1]);
            if (max[i] > max[maxIndex]) {
                maxIndex = i;
            }
        }
        return max[maxIndex];
    }

    public static void main(String[] args) {
        MaxSubArray c = new MaxSubArray();
        System.out.println(c.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1 }));
        System.out.println(c.maxSubArray(new int[] { 1 }));
        System.out.println(c.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}