import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * Given a string, find the length of the longest substring without repeating
     * characters.
     * 
     * Input: "abcabcbb"
     * 
     * Output: 3
     * 
     * Explanation: The answer is "abc", with the length of 3
     * 
     * 
     * Input: "pwwkew"
     * 
     * Output: 3
     * 
     * Explanation: The answer is "wke", with the length of 3. Note that the answer
     * must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring1(String s) {
        int i = 0;
        int j = 0;
        int longest = 0;
        Set<Character> hashSet = new HashSet<>();

        while (j < s.length()) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                j++;
                longest = Math.max(hashSet.size(), longest);
            } else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();

        System.out.println(l.lengthOfLongestSubstring1("abcabcbb"));
    }

}