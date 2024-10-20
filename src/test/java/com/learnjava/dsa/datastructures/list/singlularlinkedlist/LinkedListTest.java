package com.learnjava.dsa.datastructures.list.singlularlinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void prependAddsElementToBeginning() {
        LinkedList<Integer> list = new LinkedList<>();
        list.prepend(1);
        assertEquals(1, list.getValue(0));
    }

    @Test
    void appendAddsElementToEnd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.getValue(1));
    }

    @Test
    void insertAddsElementAtIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(3);
        list.insert(1, 2);
        assertEquals(2, list.getValue(1));
    }

    @Test
    void removeFirstRemovesElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.getValue(0));
    }

    @Test
    void removeLastRemovesElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.removeLast());
        assertEquals(1, list.getValue(0));
    }

    @Test
    void removeAtIndexRemovesElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(2, list.remove(1));
        assertEquals(3, list.getValue(1));
    }

    @Test
    void reverseReversesList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.reverse();
        assertEquals(3, list.getValue(0));
        assertEquals(2, list.getValue(1));
        assertEquals(1, list.getValue(2));
    }

    @Test
    void sizeReturnsNumberOfElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.size());
    }

    @Test
    void isEmptyReturnsTrueForEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseForNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clearEmptiesTheList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void containsReturnsTrueIfElementExists() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        assertTrue(list.contains(1));
    }

    @Test
    void containsReturnsFalseIfElementDoesNotExist() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        assertFalse(list.contains(2));
    }

    @Test
    void indexOfReturnsCorrectIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void lastIndexOfReturnsCorrectIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(1);
        assertEquals(2, list.lastIndexOf(1));
    }
}