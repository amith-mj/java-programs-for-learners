package com.learnjava.dsa;

/**
 * This class Explains the Big `O` Time complexity calculation
 * With example of all common Big `O` complexities such as O(1), O(n), O(log n), O(n^2).
 */
public class TimeAndSpaceComplexity {

    /**
     * <p>This is simple example of O(1) complexity, which is most efficient.
     * Here only one operation is performed one time.
     * No. Of operations executed will not change based on n value.
     * Either n=1 or n=10,00,000 only one addition operation is performed.
     * Hence, Time complexity is O(1). </p
     * <br>
     * <p>Here only one space is required to store input n.
     * Even if n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)</p>
     *
     * @param num add twice with num
     */
    protected void sum(int num) {
        System.out.println(num + num);
    }

    /**
     * @param n add twice with n
     * @Rule: 1 set of operations
     * This method explains the unit of operations rule.
     * Here addition operation performed 2 times by n.
     * But no of operations will not change if the value of n changes. it will always remain 2.
     * So can be represented as O(2). But as per this rule
     * We should always consider set of operations as 1 unit of operations.
     * Because Big `O` represents change in No. of same set of operations executed based on change in `n` value.
     * Hence, O(2) ~= O(1).
     * ---***---
     * Here only one space is required to store input n.
     * Even if n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)
     */
    protected void doubleSum(int n) {
        n = n + n;
        System.out.println(n + n);
    }

    /**
     * This method explains the basic O(n) complexity.
     * Here there is one print operation is getting executed n times in the loop.
     * If n increases No. of operations executed also be increased in the same amount.
     * No. of operations is directly proportional to n.
     * Hence, Time complexity is O(n).
     * ---***---
     * Here only one space is required to store input n.
     * Even if n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)
     *
     * @param n print series up to n
     */
    protected void printSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    /**
     * @param n print series up to n
     * @Rule: Drop constants
     * This method is explaining the drop constant rule.
     * There are 2 for loops to be executed in this method each looping through 0 to n.
     * which can be represented as O(n + n) = O(2n)
     * here 2 is constant will not change if n is increased or decreased.
     * Since Big `O` is representing change in executable operations based on `n`, Constants should be neglected.
     * Hence, Time complexity is O(2n) ~= O(n)
     * ---***---
     * Here only one space is required to store input n.
     * Even if n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)
     */
    protected void printSeriesTwice(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        for (int j = 0; j < n; j++) {
            System.out.println(j);
        }
    }

    /**
     * This method is an example of O(n^2) complexity.
     * Here One print operation is executed by nested loops.
     * It will be n times of 0-n.
     * Can be represented as, O(n * n) = O(n^2).
     * ---***---
     * Here only one space is required to store input n.
     * Even if n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)
     *
     * @param n print n times of n
     */
    protected void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "-" + j);
            }
        }
    }

    /**
     * @param n print in different complexities.
     * @Rule: Drop Non-Dominant values
     * This method explains drop non-dominant rule.
     * In this example there is 1 operation executed in O(n^2) complexity,
     * and again same operation executed in O(n) complexity.
     * Can be represented as, O(n^2) + O(n) = O(n^2 + n).
     * Here n^2 is significantly greater value than n. so n^2 is dominant complexity,
     * and O(n) is non-dominant, it should be neglected.
     * Hence, O(n^2+n) ~= O(n^2).
     * ---***---
     * Here only one space is required to store input n.
     * even n value increased or decreased 1 space is enough to store input.
     * Hence, Space complexity is O(1)
     */
    protected void printItems(int n) {
        System.out.println("O(n^2) complexity");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "-" + j); //O(n^2)
            }
        }

        System.out.println("O(n) complexity");
        for (int j = 0; j < n; j++) {
            System.out.println(j);  //O(n)
        }
    }

    /**
     * This method explains Binary Search algorithm,
     * And How log n complexity should be calculated.
     * Whenever performing set of operations in the collection of data then length of the collection considered as `n`.
     * ---***---
     * Here Array of n space required to store the values for entire operation.
     * Hence, Space complexity is O(n)
     *
     * @param search value to be searched
     * @return index value if element found, else -1
     */
    protected int binarySearch(int search) {
        // consider input as sorted array. length of the array is `n`
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int left = 0; //left pointer
        int right = arr.length - 1; //right pointer
        /**
         * Here loop will run logarithmically.
         * worst case complexity is O(log n).
         * current input n=10, 2^3 = 8 and 2^4 = 16. n lies between 2^4
         * Hence, loop will run 4 times in the worst case scenario.
         * current input O(log 10) (base 2).
         */
        while (left <= right) { //Run in loop until left and right pointer intersects.
            System.out.println("left: " + left + "-" + arr[left] + "; right: " + right + "-" + arr[right]);
            int mid = (left + right) / 2;
            System.out.println("Mid pointer: " + mid + "-" + arr[mid]);
            if (search == arr[mid]) { //if search element found return the index
                return mid;
            } else if (search < arr[mid]) { //if search element less than mid-index value
                right = mid - 1;            //Discard right half by moving right pointer to mid-1 index.
            } else {                        //id search element greater than mid-index value
                left = mid + 1;             //Discard left half by moving left pointer to mid + 1 index.
            }
        }
        // -1 represents search element is not found
        return -1;
    }

    /**
     * @param a n for series 1
     * @param b n for series 2
     * @Rule: different reference
     * In this example there is 2 for loops executing print operations n times like 2n complexity.
     * But here both loops have different n values, It can be significantly different numbers.
     * So we cannot consider commonly as n. but must use different reference
     * i.e., O(a + b) it cannot be reduced further.
     * ---***---
     * Here 2 space required to store 2 inputs,
     * Can be represented as O(1 + 1) = O(2)
     * As it can be considered 1 set of space for inputs, space will not increase if input values a & b increased.
     * Hence, Space complexity O(1).
     */
    protected void addTwoSeries(int a, int b) {
        for (int i = 0; i < a; i++) {
            System.out.println(i); //O(n) ~ O(a)
        }
        for (int j = 0; j < b; j++) {
            System.out.println(j); //O(n) ~ O(b)
        }
    }


}
