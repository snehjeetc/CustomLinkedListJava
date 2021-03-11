package com.customdatastructure.java;

import org.junit.Assert;
import org.junit.Test;

public class MyCustomLinkedListTestClass {

    @Test
    public void given3NumbersWhenAddedToLinkedListShouldBeAddedToTop(){
        Node<Integer> myFirstNode = new Node<>(70);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(56);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.add(mySecondNode);
        myLinkedList.add(myThirdNode);
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().equals(mySecondNode) &&
                myLinkedList.getHead().getNext().getNext().equals(myFirstNode);
        Assert.assertTrue(result);
    }
}
