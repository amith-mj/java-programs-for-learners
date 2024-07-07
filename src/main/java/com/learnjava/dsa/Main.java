package com.learnjava.dsa;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        TimeAndSpaceComplexity complexity = new TimeAndSpaceComplexity();

        //This method explains O(n) time complexity.
        System.out.println("Time Complexity O(n): ");
        complexity.printSeries(10);

        //This method explain Drop constant rule and O(2n) = O(n)
        System.out.println("Drop Constant rule:");
        complexity.printSeriesTwice(10);

        //This method explains simple O(1) time complexity:
        System.out.println("Time Complexity O(1):");
        complexity.sum(5);

        //This method explains set of operations:
        System.out.println("Set of operations: O(2) ~= O(1)");
        complexity.doubleSum(5);

        //This method explains drop non-dominants rule:
        System.out.println("Drop Non-Dominant Values:");
        complexity.printItems(10);

        //This method explains O(n^2)
        System.out.println("Time Complexity O(n^2):");
        complexity.printMatrix(10);

        //This method explains O(log n) complexity by using binary search
        System.out.println("Time Complexity O(log n)");
        System.out.println("Search result:" + complexity.binarySearch(0));

        //This method explains different references rule
        System.out.println("Different References");
        complexity.addTwoSeries(10, 20);
    }
}
