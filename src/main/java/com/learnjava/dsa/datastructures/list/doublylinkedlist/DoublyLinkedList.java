package com.learnjava.dsa.datastructures.list.doublylinkedlist;

import com.learnjava.dsa.datastructures.list.List;

/**
 * <h1>Doubly Linked List</h1>
 * <p>
 * This is a basic doubly linked list data structure to store a collection of values.
 * This sample data structure class includes comments to explain its features and
 * the time complexity of each operation.
 * </p>
 * <h2>Things to Remember</h2>
 * <ul>
 *     <li>Doubly Linked List is bi-directional.</li>
 *     <li>Insertion order is maintained, hence elements can be accessed by index.</li>
 *     <li>Faster in inserting elements at the beginning and end of the list. O(1)</li>
 *     <li>Faster in deleting elements at the beginning and end of the list. O(1)</li>
 *     <li>Slower in accessing elements based on index. O(n)</li>
 *     <li>Allows duplicate elements.</li>
 * </ul>
 * <b>NOTE:</b>
 * <p><i>
 * This class is created as generic to store any type of data.
 * It is recommended to learn generics first to understand better.
 * Otherwise, assume E as Integer to proceed without confusion.
 * (Here, E is a generic type placeholder.)
 * </i></p>
 *
 * @param <E> the type of elements in this list
 */
public class DoublyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Node class representing each element in the doubly linked list.
     *
     * @param <E> the type of elements in this node
     */
    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        /**
         * Constructs a new Node with the specified element.
         *
         * @param value the value to be stored in the node
         */
        Node(E value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Prepends a new element to the beginning of the doubly linked list.
     * This operation has a time complexity of O(1).
     *
     * @param value the value to be prepended to the list
     */
    @Override
    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Appends a new element to the end of the doubly linked list.
     * This operation has a time complexity of O(1).
     *
     * @param value the value to be appended to the list
     */
    @Override
    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    /**
     * Inserts a new element at the specified index in the doubly linked list.
     * This operation has a time complexity of O(n) in the worst case.
     *
     * @param index the position at which the new element should be inserted
     * @param value the value to be inserted into the list
     * @return true if the value is successfully inserted, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public boolean insert(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node<E> newNode = new Node<>(value);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
            size++;
        }
        return true;
    }

    /**
     * Removes and returns the first element from the doubly linked list.
     * This operation has a time complexity of O(1).
     *
     * @return the value of the removed element
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        E value = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return value;
    }

    /**
     * Removes and returns the last element from the doubly linked list.
     * This operation has a time complexity of O(1).
     *
     * @return the value of the removed element
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public E removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        E value = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    /**
     * Removes and returns the element at the specified index in the doubly linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the element to be removed
     * @return the value of the removed element
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return current.value;
        }
    }

    /**
     * Retrieves the value at the specified index in the doubly linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the value to retrieve
     * @return the value at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public E getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    /**
     * Sets the value at the specified index in the doubly linked list.
     * This operation has a time complexity of O(n).
     *
     * @param index the position of the value to set
     * @param value the new value to set at the specified index
     * @return true if the value is successfully set, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public boolean set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
        return true;
    }

    /**
     * Returns the number of elements in the doubly linked list.
     * This operation has a time complexity of O(1).
     *
     * @return the number of elements in the list
     */
    @Override
    public long size() {
        return size;
    }

    /**
     * Checks if the doubly linked list is empty.
     * This operation has a time complexity of O(1).
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from the doubly linked list.
     * This operation has a time complexity of O(1).
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Prints all the elements in the doubly linked list.
     * This operation has a time complexity of O(n).
     */
    @Override
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Reverses the order of elements in the doubly linked list.
     * This operation has a time complexity of O(n).
     */
    public void reverse() {
        Node<E> current = head;
        Node<E> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    /**
     * Checks if the doubly linked list contains the specified value.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to check for in the list
     * @return true if the list contains the specified value, false otherwise
     */
    @Override
    public boolean contains(E value) {
        Node<E> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value in the doubly linked list.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to search for in the list
     * @return the index of the first occurrence of the specified value, or -1 if the list does not contain the value
     */
    @Override
    public int indexOf(E value) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified value in the doubly linked list.
     * This operation has a time complexity of O(n).
     *
     * @param value the value to search for in the list
     * @return the index of the last occurrence of the specified value, or -1 if the list does not contain the value
     */
    @Override
    public int lastIndexOf(E value) {
        Node<E> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }
}