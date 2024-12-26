package com.learnjava.dsa.datastructures.list.singlularlinkedlist;

import com.learnjava.dsa.datastructures.list.List;

/**
 * <h1>Linked List (Singular)</h1>
 * <p>
 * It's a basic singular linked list data structure to store the collection of values
 * This sample data structure class has comments to explain its features and
 * time complexity of each operation as well.
 * </p>
 *<h2>Things to remember</h2>
 * <ul>
 *     <li>Singular Linked List is uni-directional</li>
 *     <li>Insertion order is maintained. Hence, can be accessed by index</li>
 *     <li>Faster in inserting elements at beginning and end of the list. O(1)</li>
 *     <li>Faster in deleting elements in beginning of the list. O(1)</li>
 *     <li>Slower accessing the elements based on index. O(n)</li>
 *     <li>Slower deleting values at the end or at any intermediate index. O(n)</li>
 *     <li>Allows duplicate elements</li>
 * </ul>
 * <b>NOTE:</b>
 * <p><i>
 * This class created as generic to store any type of data.
 * It's recommended to learn generics first to understand better.
 * Otherwise, Assume E as Integer to proceed without confusion.
 * (here E is generic type placeholder)
 * </i></p>
 */
public class LinkedList<E> implements List<E> {

    /**
     * Node class is a basic building block of Linked List which stores the actual data and pointer to the next Node
     * Collection of Nodes which points one another in one direction (uni-direction) forms the singular linked list data structure.
     *
     * @param <E>
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E element) {
            this.value = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private long length;

    private Node<E> get(int index) {
        if(isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        Node<E> temp = head;
        for(int i=0; i< length; i++){
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public E getValue(int index) {
        return get(index).value;
    }

    @Override
    public boolean set(int index, E value) {
        Node<E> temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    @Override
    public void printList() {
        Node<E> temp = head;
        while (temp !=  null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+length;
    }

    private boolean isIndexNotValid(int index) {
        return index < 0 || index >= length;
    }

    @Override
    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if(length == 0){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    @Override
    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if(length == 0) {
          head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public boolean insert(int index, E value) {
        if(isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    @Override
    public E removeFirst() {
        if(length == 0)
            throw new UnsupportedOperationException("List is already empty");

        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0)
            return null;
        return temp.value;
    }

    @Override
    public E removeLast() {
        if(length == 0)
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

    @Override
    public E remove(int index) {
        if(isIndexNotValid(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if(index == 0)
            return removeFirst();
        if(index == length)
            return removeLast();

        Node<E> prev = get(index -1);
        Node<E> temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp.value;
    }

    @Override
    public void reverse() {
        Node<E> temp = head;
        head = tail;
        tail = temp;

        Node<E> after = temp.next;
        Node<E> before = null;

        for(int i=0; i<length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }
}
