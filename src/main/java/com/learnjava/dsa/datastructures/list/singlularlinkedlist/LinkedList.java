package com.learnjava.dsa.datastructures.list.singlularlinkedlist;

import com.learnjava.dsa.datastructures.list.List;

/**
 * <h1>Singular Linked List</h1>
 * <p>
 * This is a basic singular linked list data structure to store a collection of values.
 * This sample data structure class includes comments to explain its features and
 * the time complexity of each operation.
 * </p>
 * <h2>Things to Remember</h2>
 * <ul>
 *     <li>Singular Linked List is uni-directional.</li>
 *     <li>Insertion order is maintained, hence elements can be accessed by index.</li>
 *     <li>Faster in inserting elements at the beginning and end of the list. O(1)</li>
 *     <li>Faster in deleting elements at the beginning of the list. O(1)</li>
 *     <li>Slower in accessing elements based on index. O(n)</li>
 *     <li>Slower in deleting values at the end or at any intermediate index. O(n)</li>
 *     <li>Allows duplicate elements.</li>
 * </ul>
 * <b>NOTE:</b>
 * <p><i>
 * This class is created as generic to store any type of data.
 * It is recommended to learn generics first to understand better.
 * Otherwise, assume E as Integer to proceed without confusion.
 * (Here, E is a generic type placeholder.)
 * </i></p>
 */
public class LinkedList<E> implements List<E> {

    /**
     * Node class is a basic building block of Linked List which stores the actual data and pointer to the next Node.
     * Collection of Nodes which points one another in one direction (uni-direction) forms the singular linked list data structure.
     *
     * @param <E> the type of elements held in this Node
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        /**
         * Constructs a new Node with the specified element.
         *
         * @param element the element to be stored in this Node
         */
        Node(E element) {
            this.value = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private long length;

    /**
     * Retrieves the node at the specified index in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= length)
     */
    private Node<E> get(int index) {
        if (isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        Node<E> temp = head;
        for (int i = 0; i < length; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Retrieves the value at the specified index in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the value to retrieve
     * @return the value at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= length)
     */
    @Override
    public E getValue(int index) {
        return get(index).value;
    }

    /**
     * Sets the value at the specified index in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the value to set
     * @param value the new value to set at the specified index
     * @return true if the value is successfully set, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= length)
     */
    @Override
    public boolean set(int index, E value) {
        Node<E> temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Prints all the elements in the linked list.
     * This operation has a time complexity of O(n).
     */
    @Override
    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Constructs an out-of-bounds message for the specified index.
     *
     * @param index the index that is out of bounds
     * @return the out-of-bounds message
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + length;
    }

    /**
     * Checks if the specified index is not valid.
     *
     * @param index the index to check
     * @return true if the index is not valid, false otherwise
     */
    private boolean isIndexNotValid(int index) {
        return index < 0 || index >= length;
    }

    /**
     * Prepends a new element to the beginning of the linked list.
     * This operation has a time complexity of O(1).
     *
     * @param value the value to be prepended to the list
     */
    @Override
    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Appends a new element to the end of the linked list.
     * This operation has a time complexity of O(1).
     *
     * @param value the value to be appended to the list
     */
    @Override
    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Inserts a new element at the specified index in the linked list.
     * This operation has a time complexity of O(n) in the worst case.
     *
     * @param index the position at which the new element should be inserted
     * @param value the value to be inserted into the list
     * @return true if the insertion is successful, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > length)
     */
    @Override
    public boolean insert(int index, E value) {
        if (isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * Removes and returns the first element from the linked list.
     * This operation has a time complexity of O(1).
     *
     * @return the value of the removed element, or null if the list is empty
     * @throws UnsupportedOperationException if the list is already empty
     */
    @Override
    public E removeFirst() {
        if (length == 0) {
            throw new UnsupportedOperationException("List is already empty");
        }
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0)
            return null;
        return temp.value;
    }

    /**
     * Removes and returns the last element from the linked list.
     * This operation has a time complexity of O(n).
     *
     * @return the value of the removed element
     * @throws UnsupportedOperationException if the list is already empty
     */
    @Override
    public E removeLast() {
        if (length == 0)
            throw new UnsupportedOperationException("List is already empty");
        Node<E> temp = head;
        Node<E> prev = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        return temp.value;
    }

    /**
     * Removes and returns the element at the specified index in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the element to be removed
     * @return the value of the removed element
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= length)
     */
    @Override
    public E remove(int index) {
        if (isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if (index == 0)
            return removeFirst();
        if (index == length)
            return removeLast();

        Node<E> prev = get(index - 1);
        Node<E> temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp.value;
    }

    /**
     * Reverses the order of elements in the linked list.
     * This operation has a time complexity of O(n).
     */
    @Override
    public void reverse() {
        Node<E> temp = head;
        head = tail;
        tail = temp;

        Node<E> after = temp.next;
        Node<E> before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    /**
     * Returns the number of elements in the linked list.
     * This operation has a time complexity of O(1).
     *
     * @return the number of elements in the list
     */
    @Override
    public long size() {
        return length;
    }

    /**
     * Checks if the linked list is empty.
     * This operation has a time complexity of O(1).
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Removes all elements from the linked list.
     * This operation has a time complexity of O(1).
     */
    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return a string representation of the linked list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> temp = head;
        while (temp != null) {
            sb.append(temp.value).append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }

    /**
     * Checks if the linked list contains the specified value.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to check for in the list
     * @return true if the list contains the specified value, false otherwise
     */
    @Override
    public boolean contains(E value) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.value.equals(value))
                return true;
            temp = temp.next;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to search for in the list
     * @return the index of the first occurrence of the specified value, or -1 if the list does not contain the value
     */
    @Override
    public int indexOf(E value) {
        Node<E> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.value.equals(value))
                return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified value in the linked list.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to search for in the list
     * @return the index of the last occurrence of the specified value, or -1 if the list does not contain the value
     */
    @Override
    public int lastIndexOf(E value) {
        Node<E> temp = head;
        int index = 0;
        int lastIndex = -1;
        while (temp != null) {
            if (temp.value.equals(value))
                lastIndex = index;
            temp = temp.next;
            index++;
        }
        return lastIndex;
    }

}
