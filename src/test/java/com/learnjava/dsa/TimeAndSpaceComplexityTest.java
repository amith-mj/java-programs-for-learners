package com.learnjava.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeAndSpaceComplexityTest {

    @Test
    void sumAddsCorrectly() {
        System.out.println("Time Complexity O(1):");
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.sum(5));
    }

    @Test
    void doubleSumAddsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.doubleSum(5));
    }

    @Test
    void printSeriesPrintsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.printSeries(5));
    }

    @Test
    void printSeriesTwicePrintsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.printSeriesTwice(5));
    }

    @Test
    void printMatrixPrintsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.printMatrix(5));
    }

    @Test
    void printItemsPrintsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.printItems(5));
    }

    @Test
    void binarySearchFindsElement() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertEquals(4, tsc.binarySearch(8));
    }

    @Test
    void binarySearchReturnsMinusOneForNotFound() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertEquals(-1, tsc.binarySearch(7));
    }

    @Test
    void addTwoSeriesPrintsCorrectly() {
        TimeAndSpaceComplexity tsc = new TimeAndSpaceComplexity();
        assertDoesNotThrow(() -> tsc.addTwoSeries(3, 4));
    }
}