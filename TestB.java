import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TestB {

    // ==================================================
    // Sample test:
    // 42 ft in in => 504 (42 * 12 = 504)
    // 504 in in ft => 42 (504 / 12 = 42)
    // 10 fur in lea => 0.4166666666667 (10 / 10 / 8 / 3 = 0.4166666666667)
    // 10 mi in ft => 52800 (8 * 10 * 22 * 3 = 52800)
    // ==================================================

    // lea = 3 mi
    // mi = 8 fur
    // fur = 10 ch
    // ch = 22 yd
    // yd = 3 ft
    // ft = 12in
    // in = 1000 th
    // th

    // Solution:
    // Makes use of a hashmap to map units to their corresponding length.
    // Makes use of a list of units, to map the order of the units.
    // This is then used to find out number of steps to convert.
    // E.g. inch to foot = 1 step.
    public String problemB(HashMap<String, Integer> hm, List<String> units, String input) {
        // Assign result to 1 as a starting value. Because there will always be 1 unit,
        // otherwise it will be 0, which converts to 0 and is obvious.
        double result = 1;

        // Split the input into separate string words, in order to find out the amount
        // to calculate, the unit to be converted and the target unit to be converted
        // to. Basically making the code understand the input sentence.

        // This code's unit name and value mapping only uses the units' abbreviations.
        // Therefore the helper method unitNameConverter(String s) is used to convert
        // full name of a unit to its abbreviation.
        // Working with one format makes it easier. (Could as well go the other way
        // around.)
        String[] arr = input.split(" ");
        int amount = Integer.parseInt(arr[0]);
        String toBeConvertedUnit = unitNameConverter(arr[1]);
        String targetUnit = unitNameConverter(arr[3]);

        // First multiply the result with amount, which is based on the amount of units
        // given in the input.
        result = result * amount;

        // Get indices from the unit list, which will be used to calculate how to step
        // upwards/downwards in the unit list. E.g. inch to foot = 1 step.
        // The hashmap is then used for getting a units conversion value.
        // If wanting to convert 42 ft to in: There will be 1 step, where this step will
        // involve multiplication of 12, because the hashmap has mapping ft -> 12.
        // Example: 42 ft to in: 42*12 = 504 inches.
        int toBeConvertedUnitIndex = units.indexOf(toBeConvertedUnit);
        int targetUnitIndex = units.indexOf(targetUnit);

        // Stepping upwards in units. Involves division, in order to convert the bigger
        // unit to the smaller.
        if (toBeConvertedUnitIndex < targetUnitIndex) {
            for (int i = toBeConvertedUnitIndex; i < targetUnitIndex; i++) {
                result = result / (int) hm.get(units.get(i + 1));
            }
            // Stepping downwards in units. Involves multiplication, in order to convert the
            // smaller unit to the bigger.
        } else if (toBeConvertedUnitIndex > targetUnitIndex) {
            for (int i = toBeConvertedUnitIndex; i > targetUnitIndex; i--) {
                result = result * (int) hm.get(units.get(i));
            }
        } else {
            // In case the same unit is to be converted to itself, then we obviously return
            // the same input.
            result = amount;
        }

        // Remove trailing zeros.
        BigDecimal number = new BigDecimal(Double.toString(result));

        return number.stripTrailingZeros().toPlainString();
    }

    // Helper method to convert units' names to abbreviations.
    // Because this solution uses one name format.
    private String unitNameConverter(String s) {
        if (s.equals("th") || s.equals("thou")) {
            return "th";
        } else if (s.equals("in") || s.equals("inch")) {
            return "in";
        } else if (s.equals("ft") || s.equals("foot")) {
            return "ft";
        } else if (s.equals("yd") || s.equals("yard")) {
            return "yd";
        } else if (s.equals("ch") || s.equals("chain")) {
            return "ch";
        } else if (s.equals("fur") || s.equals("furlong")) {
            return "fur";
        } else if (s.equals("mi") || s.equals("mile")) {
            return "mi";
        } else {
            return "lea";
        }
    }

    public static void main(String[] args) {
        TestB test = new TestB();
        Scanner sc = new Scanner(System.in);

        // Map units to their conversion values.
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("th", 1);
        hm.put("in", 1000);
        hm.put("ft", 12);
        hm.put("yd", 3);
        hm.put("ch", 22);
        hm.put("fur", 10);
        hm.put("mi", 8);
        hm.put("lea", 3);

        // Map units to their order. Smallest down, biggest up.
        List<String> units = new ArrayList<String>();
        units.add("th");
        units.add("in");
        units.add("ft");
        units.add("yd");
        units.add("ch");
        units.add("fur");
        units.add("mi");
        units.add("lea");

        while (sc.hasNextLine()) {
            String testCase = sc.nextLine();
            System.out.println(test.problemB(hm, units, testCase));
            break;
        }
        // Close after finished with given input.
        sc.close();
    }
}
