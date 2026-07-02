package dsa.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped by inner loop, array is sorted
            if (!swapped) break;
        }
    }

    // Quick Sort helper method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] scores1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array for Bubble Sort: " + Arrays.toString(scores1));
        bubbleSort(scores1);
        System.out.println("After Bubble Sort: " + Arrays.toString(scores1));

        int[] scores2 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("\nOriginal Array for Quick Sort: " + Arrays.toString(scores2));
        quickSort(scores2, 0, scores2.length - 1);
        System.out.println("After Quick Sort: " + Arrays.toString(scores2));
    }
}
