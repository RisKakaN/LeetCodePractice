import java.util.LinkedList;
import java.util.List;

public class PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when
     * it reads the same backward as forward.
     * 
     * Input: 121, Output: true
     * 
     * Input: -121, Output: false
     * 
     * Explanation: From left to right, it reads -121. From right to left, it
     * becomes 121-. Therefore it is not a palindrome.
     * 
     * Input: 10, Output: false
     * 
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;

        List<Integer> digitList = new LinkedList<>();

        while (x > 0) {
            int d = x % 10;
            digitList.add(0, d);
            x = x / 10;
        }

        Integer[] array = digitList.toArray(new Integer[0]);

        int i = 0;
        int j = array.length - 1;
        int middle = (array.length % 2 == 0) ? array.length / 2 : array.length / 2 + 1;

        while (middle <= j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        int reverse = 0;
        int copy = x;
        while (copy > 0) {
            reverse = reverse * 10 + (copy % 10);
            copy = copy / 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(-121));
        System.out.println(pn.isPalindrome(112211));
        System.out.println(pn.isPalindrome(1));
        System.out.println(pn.isPalindrome(11));
        System.out.println(pn.isPalindrome(0));
        System.out.println(pn.isPalindrome(133343331));

        // 112 211
        // 2,2
        // 1113111
        // 3
        // 11122111

        // 1.5 = 1
    }
}