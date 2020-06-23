import java.util.HashMap;

public class ContainerWithMostWater {

    /**
     * Input: [1,8,6,2,5,4,8,3,7]
     * 
     * Output: 49
     * 
     * Form area with two indices in the array, together with x-axis, to form
     * biggest area.
     * 
     * E.g. indices 8 and 7. Highest will be 7, and space between them is 7.
     * 
     * Result: 7*7 = 49.
     */

    public int maxArea1(int[] height) {
        int biggest = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int currentArea = Math.abs(i - j) * Math.min(height[i], height[j]);
                biggest = Math.max(biggest, currentArea);
            }
        }
        return biggest;
    }

    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int maxArea(int[] height) {
        return maxAreaHelper(height, height.length - 1, height.length - 1, 0);
    }

    public int maxAreaHelper(int[] height, int i, int j, int max) {
        if (i <= 0) {
            return i;
        }
        if (j <= 0) {
            return j;
        }
        int currentArea = Math.abs(i - j) * Math.min(height[i], height[j]);


        return Math.max(maxAreaHelper(height, --i, j, Math.max(max, currentArea)),
                maxAreaHelper(height, i, --j, Math.max(max, currentArea)));
    }

    public static void main(String[] args) {
        ContainerWithMostWater a = new ContainerWithMostWater();
        System.out.println(a.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    // System.out.println("i: " + i + ", j: " + j + ", space: " + Math.abs(i - j) +
    // ", area: " + currentArea);

}