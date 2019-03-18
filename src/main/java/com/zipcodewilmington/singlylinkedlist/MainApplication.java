package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
//        list.insertAtStart(25);
//        list.insertAt(0,55);
//
//        list.deleteAt(2);
        //list.get(0);
        list.show();

    }
}

