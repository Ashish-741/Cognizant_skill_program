package dsa.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringOperations {

    // Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Find the first non-repeating character using LinkedHashMap
    public static Character firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String testStr = "madam";
        System.out.println("Is '" + testStr + "' a palindrome? " + isPalindrome(testStr));

        String input = "cognizant";
        System.out.println("First non-repeating character in '" + input + "': " + firstNonRepeatingChar(input));
    }
}
