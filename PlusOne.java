import java.util.Arrays;

public class PlusOne {

    /**
     * Given a non-empty array of digits representing a non-negative integer, plus
     * one to the integer.
     * 
     * The digits are stored such that the most significant digit is at the head of
     * the list, and each element in the array contain a single digit.
     * 
     * You may assume the integer does not contain any leading zero, except the
     * number 0 itself.
     * 
     * Input: [1,2,3], Output: [1,2,4]
     * 
     * Input: [4,3,2,1], Output: [4,3,2,2]
     */

    public int[] plusOne1(int[] digits) {
        long sum = 0;
        boolean increaseSize = true;
        for (int i : digits) {
            sum = (sum * 10) + i;
            if (i != 9)
                increaseSize = false;
        }
        sum += 1;
        int[] result = new int[increaseSize ? digits.length + 1 : digits.length];
        int index = result.length - 1;
        while (sum > 0) {
            result[index] = (int) (sum % 10);
            sum = sum / 10;
            index--;
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, result.length - 1);

        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        System.out.println(Arrays.toString(po.plusOne(new int[] {})));
        System.out.println(Arrays.toString(po.plusOne(new int[] { 0 })));
        System.out.println(Arrays.toString(po.plusOne(new int[] { 0, 1, 2, 3 })));
        System.out.println(Arrays.toString(po.plusOne(new int[] { 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(po.plusOne(new int[] { 9, 9, 9, 9 })));
        System.out.println(Arrays.toString(po.plusOne(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
    }
}