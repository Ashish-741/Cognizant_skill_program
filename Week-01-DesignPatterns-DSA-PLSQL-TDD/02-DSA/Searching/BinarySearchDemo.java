package dsa.searching;

import java.util.Arrays;

public class BinarySearchDemo {

    // Iterative binary search implementation
    public static int binarySearch(int[] sortedArray, int target) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedArray[mid] == target) {
                return mid; // Target found
            }
            if (sortedArray[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 105, 110, 120, 135, 150, 180, 200};
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIds));

        int targetId = 135;
        int index = binarySearch(employeeIds, targetId);

        if (index != -1) {
            System.out.println("Employee ID " + targetId + " found at index: " + index);
        } else {
            System.out.println("Employee ID " + targetId + " not found in directory.");
        }
    }
}
