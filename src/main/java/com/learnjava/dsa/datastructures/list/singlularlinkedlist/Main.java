package com.learnjava.dsa.datastructures.list.singlularlinkedlist;


import com.learnjava.dsa.datastructures.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        linkedList.printList();

        linkedList.reverse();

        linkedList.printList();
        // linkedList.getValue(-1);
        linkedList.clear();
        linkedList.removeFirst();
        linkedList.printList();
    }
}
