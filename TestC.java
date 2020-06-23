import java.math.BigInteger;
import java.util.Scanner;

public class TestC {

    // ==================================================
    // Sample test:
    // at => 2
    // ordeals => 5040
    // abcdefghijklmnopqrstuvwxyz => 403291461126605635584000000
    // abcdefghijklmabcdefghijklm => 49229914688306352000000
    // abcdABCDabcd => 29937600
    // ==================================================

    // Solution:
    // Make use of the permutation calculation formula.
    // Handle upper and lower cases, and repetitions, by using an array.
    // BigInteger is used overall, to handle very big numbers.
    public BigInteger problemC(String input) {
        // Size of alphabet with lower and upper cases. (including some other characters
        // lying in between upper cases and lower cases)
        // This array will contain repetitions if they exist.
        int[] alphabet = new int[58];

        // Make use of character calculations ranging from 'A' to 'z'.
        // If a character is repeated, increment the default array value of the index by
        // 1.
        // E.g. a character that is repeated 3 times, has the value 3.
        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'A']++;
        }

        // First do the normal permutation, which ignores repetitions.
        // Then use the result to calculate permutations with repetitions.
        return calculatePermutationsWithRepetitions(calculatePermutations(input.length()), alphabet);
    }

    // Calculate the permutations using standard permutation formula: n!
    // (This calculation ignores repetitions)
    private BigInteger calculatePermutations(int n) {
        BigInteger result = new BigInteger("1");
        if (n == 0 || n == 1) {
            return result;
        }

        for (int i = n; i > 0; i--) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }
        return result;
    }

    // Calculate the permutations with repetitions using the permutation formula:
    // (n!)/(x1!x2!x3!...), where x1,x2,x3,... are the repetitions.
    // Each x represents number of repetitions of that x.
    // The method takes in a BigInteger as first parameter, which is the number of
    // permutations of some n, that ignores repetitions.
    // The second parameter is an array containing repetitions.
    private BigInteger calculatePermutationsWithRepetitions(BigInteger bn, int[] repetitions) {
        for (int i = 0; i < repetitions.length; i++) {
            if (repetitions[i] != 0) {
                // Important to calculate all repetitions[i]!, which is according to the
                // formula.
                bn = bn.divide(calculatePermutations(repetitions[i]));
            }
        }
        return bn;
    }

    public static void main(String[] args) {
        TestC test = new TestC();
        Scanner sc = new Scanner(System.in);

        // Max 200 words and each word can max be 100 characters.
        int maxWords = 200;
        while (maxWords > 0 && sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.chars().allMatch(Character::isLetter)) {
                maxWords--;

                if (input.length() > 100) {
                    sc.close();
                    return;
                }
                System.out.println(test.problemC(input));
            }
        }
        // Close after finished with given input.
        sc.close();
    }
}