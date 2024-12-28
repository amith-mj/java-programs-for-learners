package com.learnjava.problemsolving;

/**
 * Problem: Diagonal Difference
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 * <p>
 *     Example:
 *     Input: [[1, 2, 3], [4, 5, 6], [9, 8, 9]] </br>
 *     Output: 2 </br>
 *     Explanation: The primary diagonal is: 1 + 5 + 9 = 15 </br>
 *                  The secondary diagonal is: 3 + 5 + 9 = 17 </br>
 *                  The difference is: |15 - 17| = 2 </br>
 */
public class DiagonalDifference {
    // Time complexity: O(n); Space complexity: O(1)
    public static int diagonalDifference(int[][] arr) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        int n = arr.length;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            leftDiagonalSum += arr[i][i];
            rightDiagonalSum += arr[i][j];
            j--;
        }
        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {9, 8, 9}};
        System.out.println(diagonalDifference(arr));
    }
}
