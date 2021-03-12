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
        myLinkedList.insert(mySecondNode, secondPosition);
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().equals(mySecondNode) &&
                myLinkedList.getHead().getNext().getNext().equals(myThirdNode);
        Assert.assertTrue(result);
    }

    @Test
    public void given3Numbers_DeletionFromFirst_fromTheAlreadyCreatedLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.pop();
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myFirstNode) == -1) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void given3Numbers_DeletionFromLast_fromTheAlreadyCreatedLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.popLast();
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myThirdNode) == -1) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void givenNumbers_inALinkedList_SearchTheValueInTheLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        System.out.println(myLinkedList);
        boolean result = myLinkedList.search(Integer.valueOf(30));
        Assert.assertTrue(result);
    }

    @Test
    public void givenNumbersInTheLinkedList_InsetionAtTheMiddlePosition(){
        int thirdPosition = 2;
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(40);
        Node<Integer> myFourthNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myFourthNode);
        myLinkedList.insert(myThirdNode, thirdPosition);
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myThirdNode) == thirdPosition) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void givenNumbersInTheLinkedList_DeletionAtTheMidPosition(){
        int thirdPosition = 2;
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(40);
        Node<Integer> myFourthNode = new Node<>(70);
        CustomLinkedList myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myFourthNode);
        myLinkedList.insert(myThirdNode, thirdPosition);
        System.out.println(myLinkedList + " Size: " + myLinkedList.length());
        myLinkedList.remove(thirdPosition);
        System.out.println(myLinkedList + " Size: " + myLinkedList.length());
        boolean result = (myLinkedList.getIndex(myThirdNode) == thirdPosition) ? true : false;
        Assert.assertFalse(result);
    }
}
