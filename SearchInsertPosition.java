
public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is
     * found. If not, return the index where it would be if it were inserted in
     * order.
     * 
     * Input: [1,3,5,6], 5 => Output: 2
     * 
     * Input: [1,3,5,6], 2 => Output: 1
     * 
     * Input: [1,3,5,6], 7 => Output: 4
     * 
     * Input: [1,3,5,6], 0 => Output: 0
     */
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = (nums.length) - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
            mid = (first + last) / 2;
        }
        return first;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 1));
        System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 3));
        System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        System.out.println(sip.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }
}