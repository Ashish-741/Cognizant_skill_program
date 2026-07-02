package dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHash {

    // Using HashMap to find Two Sum indices in O(N) time complexity
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; // Return empty array if no pair found
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15, 25, 30};
        int target = 26;

        int[] result = findTwoSum(numbers, target);
        if (result.length == 2) {
            System.out.println("Target " + target + " found at indices: " + Arrays.toString(result));
            System.out.println("Values: " + numbers[result[0]] + " + " + numbers[result[1]] + " = " + target);
        } else {
            System.out.println("No two elements sum up to target.");
        }
    }
}
