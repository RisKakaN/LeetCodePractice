public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space
     * characters ' ', return the length of last word (last word means the last
     * appearing word if we loop from left to right) in the string.
     * 
     * If the last word does not exist, return 0.
     * 
     * Note: A word is defined as a maximal substring consisting of non-space
     * characters only.
     * 
     * Input: "Hello World"
     * 
     * Output: 5
     */

    public int lengthOfLastWord(String s) {
        if (s.isEmpty())
            return 0;
        int lastIndex = s.length() - 1;
        int count = 0;
        boolean letterFound = false;
        while (lastIndex >= 0) {
            if (letterFound && s.charAt(lastIndex) == ' ')
                break;
            if (s.charAt(lastIndex) != ' ') {
                count++;
                letterFound = true;
            }
            lastIndex--;
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord(""));
        System.out.println(l.lengthOfLastWord(" "));
        System.out.println(l.lengthOfLastWord("asd ll l"));
        System.out.println(l.lengthOfLastWord("asd ll l "));
        System.out.println(l.lengthOfLastWord(" asd asdasdasdlll"));
        System.out.println(l.lengthOfLastWord("asdad asd asdasdasdlll "));
        System.out.println(l.lengthOfLastWord("asdadasdasdasdasdlll "));
    }
}