package com.learnjava.dsa.datastructures.list;

public interface List<E> {
    E getValue(int index);
    boolean set(int index, E value);
    void printList();
    void prepend(E value);
    void append(E value);
    boolean insert(int index, E value);
    E removeFirst();
    E removeLast();
    E remove(int index);
    void reverse();
    void clear();
}
