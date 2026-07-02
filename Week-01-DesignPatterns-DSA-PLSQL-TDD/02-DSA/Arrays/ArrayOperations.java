package dsa.arrays;

import java.util.Arrays;

public class ArrayOperations {

    // Method to find second largest element in an array
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    // Method to reverse an array in-place
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Second Largest Element: " + findSecondLargest(numbers));

        reverseArray(numbers);
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }
}
