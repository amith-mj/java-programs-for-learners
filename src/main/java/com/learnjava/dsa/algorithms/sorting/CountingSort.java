package com.learnjava.dsa.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Counting Sort is a sorting algorithm that sorts the elements of an array by counting the number of occurrences of each unique element in the array.
 * The count is stored in an auxiliary array and the sorting is done by mapping the count as an index of the auxiliary array.
 * <p>
 *     Properties:
 *     - It is not a comparison-based sorting algorithm.
 *     - It is an integer sorting algorithm.
 *     - It is a stable sorting algorithm.
 *     - It is not an in-place sorting algorithm.
 *     - It is a linear time complexity sorting algorithm.
 *     - It is not suitable for sorting large data sets.
 *     - It is suitable for sorting elements in a small range.
 *     - It is used as a subroutine in other sorting algorithms.
 *     - It is used when the range of elements is known.
 *     - It is used when the range of elements is not significantly greater than the number of elements.
 *     - It is used when the range of elements is not significantly less than the number of elements.
 *
 *    Time Complexity: O(n + k)
 *    Space Complexity: O(n + k)
 *    where n is the number of elements in the input array and k is the range of the input.
 */
public class CountingSort {

    /*
     * This method sorts the elements of the input array using the Counting Sort algorithm.
     * @param arr The input array to be sorted.
     * @return The sorted array.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        int n = arr.size();
        int max = arr.stream().max(Integer::compareTo).orElseGet(() -> 0);
        int min = arr.stream().min(Integer::compareTo).orElseGet(() -> 0);
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr.get(i) - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.get(i) - min] - 1] = arr.get(i);
            count[arr.get(i) - min]--;
        }

        for (int i = 0; i < n; i++) {
            arr.set(i, output[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 2, 2, 8, 3, 3, 1);
        List<Integer> sortedArr = countingSort(arr);
        System.out.println(sortedArr);
    }
}
