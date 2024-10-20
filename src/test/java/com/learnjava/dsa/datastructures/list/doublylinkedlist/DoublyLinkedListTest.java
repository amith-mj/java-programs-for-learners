package com.learnjava.dsa.datastructures.list.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void prependAddsElementToBeginning() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.prepend(1);
        assertEquals(1, list.getValue(0));
    }

    @Test
    void appendAddsElementToEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.getValue(1));
    }

    @Test
    void insertAddsElementAtIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(3);
        list.insert(1, 2);
        assertEquals(2, list.getValue(1));
    }

    @Test
    void removeFirstRemovesElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.getValue(0));
    }

    @Test
    void removeLastRemovesElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.removeLast());
        assertEquals(1, list.getValue(0));
    }

    @Test
    void removeAtIndexRemovesElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(2, list.remove(1));
        assertEquals(3, list.getValue(1));
    }

    @Test
    void reverseReversesList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.size());
    }

    @Test
    void isEmptyReturnsTrueForEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseForNonEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clearEmptiesTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void containsReturnsTrueIfElementExists() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        assertTrue(list.contains(1));
    }

    @Test
    void containsReturnsFalseIfElementDoesNotExist() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        assertFalse(list.contains(2));
    }

    @Test
    void indexOfReturnsCorrectIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void lastIndexOfReturnsCorrectIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(1);
        assertEquals(2, list.lastIndexOf(1));
    }

    @Test
    void getValueReturnsCorrectValue() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertEquals(2, list.getValue(1));
    }

    @Test
    void setValueSetsCorrectValue() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.set(1, 1);
        assertEquals(1, list.getValue(1));
    }

    @Test
    void throwsExceptionWhenIndexIsInvalid() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getValue(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 3));
    }

    @Test
    void printListPrintsCorrectly() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList();
    }

    @Test
    void printListReversePrintsCorrectly() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.reverse();
        printListPrintsCorrectly();
    }
}