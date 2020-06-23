import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        int result;
        for (int i = 0; i < nums.length; i++) {
            result = target - nums[i];
            if (hashMap.containsKey(result) && hashMap.get(result) != i) {
                return new int[] { i, hashMap.get(result) };
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        int result;
        for (int i = 0; i < nums.length; i++) {
            result = target - nums[i];
            if (hashMap.containsKey(result) && hashMap.get(result) != i) {
                return new int[] { hashMap.get(result), i };
            }
            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] test = { 4, 3, 5, 15 };
        int[] result = ts.twoSum3(test, 8);
        System.out.println(result[0] + ", " + result[1]);
    }
}