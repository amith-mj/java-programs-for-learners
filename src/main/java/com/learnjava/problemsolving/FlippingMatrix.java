package com.learnjava.problemsolving;

/**
 * Problem: Flipping Matrix
 * You are given a matrix of size n x n, where n is an even number. Each cell of the matrix contains an integer.
 * You want to create a new matrix of size n/2 x n/2, where each cell of the new matrix contains the maximum integer from the four integers of the corresponding cells of the original matrix.
 * <p>
 *     Example:
 *     Input: [[112, 42, 83, 119], [56, 125, 56, 49], [15, 78, 101, 43], [62, 98, 114, 108]]
 *     Output: 414
 *     Explanation: The maximum integers from the four integers of the original matrix are: 125, 114, 98, 119
 *     The sum of the maximum integers is: 125 + 114 + 98 + 119 = 414
 *     The maximum integer is 414
 */
public class FlippingMatrix {
    // Time complexity: O(n^2); Space complexity: O(1)
    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                sum += Math.max(Math.max(matrix[i][j], matrix[i][n - 1 - j]),
                        Math.max(matrix[n - 1 - i][j], matrix[n - 1 - i][n - 1 - j]));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{112, 42, 83, 119}, {56, 125, 56, 49}, {15, 78, 101, 43}, {62, 98, 114, 108}};
        System.out.println(flippingMatrix(matrix));
    }
}
