package main;

import implmentation.MySinglyLinkedList;

public class MyMain {
    public static void main(String[] args) {
        MySinglyLinkedList list = new MySinglyLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        list.traverse();

        list.traverseRecursion(list.getHead());
        list.reversingByRecursion(list.getHead(), null);
        System.out.println();
        list.traverse();
    }
}
