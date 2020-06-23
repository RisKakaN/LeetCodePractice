import java.util.Scanner;

public class TestA {

    // ==================================================
    // Sample test:
    // 3
    // ATCCGCTTAGAGGGATT
    // GTCCGTTTAGAAGGTTT
    // *....*.....*..*..

    // abcdefghijklmnopqrstuvwxyz
    // bcdefghijklmnopqrstuvwxyza
    // **************************

    // abcdefghijklmnopqrstuvwxyz0123456789
    // abcdefghijklmnopqrstuvwxyz0123456789
    // ....................................
    // ==================================================

    // Loop through the strings together and compare with eachother at same indices.
    public String problemA(String s1, String s2) {
        // String for storing result.
        String result = "";
        // Loop through s1 and s2, based on length of one of them. Length is the same so
        // it doesn't matter which one to use.
        for (int i = 0; i < s1.length(); i++) {
            // Make use of charAt in order to check specific character at given index.
            // If s1 and s2 characters are the same at same index, append "*" to result.
            // Else, append "." to result.
            if ((s1.charAt(i) != (s2.charAt(i)))) {
                result += "*";
            } else {
                result += ".";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TestA test = new TestA();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int testCases = sc.nextInt();
            // Make use of String array to store test strings.
            String[] testStrings = new String[testCases * 2];
            for (int i = 0; i < testStrings.length; i++) {
                testStrings[i] = sc.next();
            }

            // Loop through test strings stored in the array.
            // Make sure to increment by two, since the test strings come in pair.
            // E.g. Test case 1: Use s1 and s2, which are at indices 0 and 1.
            for (int i = 0; i < testStrings.length; i += 2) {
                System.out.println(testStrings[i]);
                System.out.println(testStrings[i + 1]);
                System.out.println(test.problemA(testStrings[i], testStrings[i + 1]));
                System.out.println();
            }
            break;
        }
        // Close after finished with given input.
        sc.close();
    }
}
