package com.learnjava.problemsolving;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem: Lonely Integer
 * Find the integer that appears only once in the given array,
 * In which all other integers appear twice.
 * <p>
 *     Example:
 *     Input: [1, 2, 3, 4, 3, 2, 1]
 *     Output: 4
 *     <br>
 *     Input: [1, 4, 7, 7, 1, 3, 4, 2, 3]
 *     Output: 2
 */
public class LonelyInteger {
    // Solution 1: Using XOR
    // Time complexity: O(n); Space complexity: O(1)
    public static int findLonelyInteger1(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        return result;
    }

    // Solution 2: Using Map
    // Time complexity: O(n); Space complexity: O(n)
    public static int findLonelyInteger2(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int result = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(findLonelyInteger1(arr));
//        ex 2
        int[] arr1 = {1, 4, 7, 7, 1, 3,  4, 2, 3};
        System.out.println(findLonelyInteger1(arr1));
    }
}
