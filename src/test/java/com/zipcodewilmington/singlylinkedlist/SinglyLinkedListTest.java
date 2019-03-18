package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @org.junit.Test
    public void testinsertAt() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        list.insertAt(0,55);
        Integer expectedValue = 55;
        //When
        Integer actualValue = list.get(0);

        //Then
        Assert.assertEquals(expectedValue,actualValue);

    }

    @org.junit.Test
    public void testdeleteAt() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        list.insert(20);
        list.deleteAt(2);
        Integer expectedValue = 20;
        //When
        Integer actualValue = list.get(2);

        //Then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @org.junit.Test
    public void testsize() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        Integer expectedSize = 3;
        //When
        Integer actualSize = list.size();

        //Then
        Assert.assertEquals(expectedSize,actualSize);
    }

    @org.junit.Test
    public void testcontains() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        Boolean expectedValue = true;
        //When
        Boolean actualValue = list.contains(45);

        //Then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @org.junit.Test
    public void testfind() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        Integer expectedIndex = 2;
        //When
        Integer actualIndex = list.find(12);

        //Then
        Assert.assertEquals(expectedIndex,actualIndex);
    }

    @org.junit.Test
    public void testcopyList() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        Integer expectedValue1 = 18;
        Integer expectedValue2= 45;
        Integer expectedValue3= 12;

        //When
        Node copiedNode = list.copyList(list.head);
        Integer actualValue1 = (Integer) copiedNode.data;
        copiedNode = copiedNode.next;
        Integer actualValue2= (Integer) copiedNode.data;
        copiedNode = copiedNode.next;
        Integer actualValue3= (Integer) copiedNode.data;

        //Then
        Assert.assertEquals(expectedValue1,actualValue1);
        Assert.assertEquals(expectedValue2,actualValue2);
        Assert.assertEquals(expectedValue3,actualValue3);
    }
    @org.junit.Test
    public void testsortList() {
        //Given
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        Integer expectedValue1 = 12;
        Integer expectedValue2= 18;
        Integer expectedValue3= 45;

        //When
        Node copiedNode = list.mergeSort(list.head);
        Integer actualValue1 = (Integer) copiedNode.data;
        copiedNode = copiedNode.next;
        Integer actualValue2= (Integer) copiedNode.data;
        copiedNode = copiedNode.next;
        Integer actualValue3= (Integer) copiedNode.data;

        //Then
        Assert.assertEquals(expectedValue1,actualValue1);
        Assert.assertEquals(expectedValue2,actualValue2);
        Assert.assertEquals(expectedValue3,actualValue3);
    }
}
