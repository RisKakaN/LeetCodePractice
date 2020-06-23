import java.util.Stack;

public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * 
     * Input: 123, Output: 321
     * 
     * Input: -123, Output: -321
     * 
     * Input: 120, Output: 21
     */

    public int reverse1(int x) {
        Stack<Integer> st = new Stack<Integer>();
        boolean isNegative = false;
        if (x < 0) {
            x *= -1;
            isNegative = true;
        }
        while (x > 0) {
            st.push(x % 10);
            x = x / 10;
        }
        long result = 0;
        long multiplier = 1;
        while (!st.empty()) {
            result += multiplier * st.pop();
            multiplier *= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? result * -1 : result);
    }

    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            x *= -1;
            isNegative = true;
        }

        long result = 0;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? result * -1 : result);
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();

        System.out.println(ri.reverse(12345678));

    }
}