package com.customdatastructure.java;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;

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

    @Test
    public void given3NumbersWhenAppendedShouldBeAddedToLast(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().equals(mySecondNode) &&
                myLinkedList.getHead().getNext().getNext().equals(myThirdNode);
        Assert.assertTrue(result);
    }

    @Test
    public void given3NumbersWhenInsertingSecondInBetweenAlreadyExistingLinkedList(){
        int secondPosition = 1;
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(myThirdNode);
        try {
            myLinkedList.insert(mySecondNode, secondPosition);
        }catch(CustomLinkedListExceptions clle){
            PrintStream obj = new PrintStream(System.out);
            clle.printStackTrace(obj);
        }
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().equals(mySecondNode) &&
                myLinkedList.getHead().getNext().getNext().equals(myThirdNode);
        Assert.assertTrue(result);
    }
}
