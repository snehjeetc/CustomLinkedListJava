package com.customdatastructure.java;

import org.junit.Assert;
import org.junit.Test;

public class MyCustomLinkedListTestClass {

    @Test
    public void given3NumbersWhenAddedToLinkedListShouldBeAddedToTop(){
        Node<Integer> myFirstNode = new Node<>(70);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(56);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.add(myFirstNode.getValue());
        myLinkedList.add(mySecondNode.getValue());
        myLinkedList.add(myThirdNode.getValue());
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().getValue().equals(mySecondNode.getValue()) &&
                myLinkedList.getHead().getNext().getNext().getValue().equals(myFirstNode.getValue());
        Assert.assertTrue(result);
    }

    @Test
    public void given3NumbersWhenAppendedShouldBeAddedToLast(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myThirdNode.getValue());
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().getValue().equals(mySecondNode.getValue()) &&
                myLinkedList.getHead().getNext().getNext().getValue().equals(myThirdNode.getValue());
        Assert.assertTrue(result);
    }

    @Test
    public void given3NumbersWhenInsertingSecondInBetweenAlreadyExistingLinkedList(){
        int secondPosition = 1;
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(myThirdNode.getValue());
        myLinkedList.insert(secondPosition, mySecondNode.getValue());
        System.out.println(myLinkedList);
        boolean result = myLinkedList.getHead().getNext().getValue().equals(mySecondNode.getValue()) &&
                myLinkedList.getHead().getNext().getNext().getValue().equals(myThirdNode.getValue());
        Assert.assertTrue(result);
    }

    @Test
    public void given3Numbers_DeletionFromFirst_fromTheAlreadyCreatedLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myThirdNode.getValue());
        myLinkedList.pop();
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myFirstNode.getValue()) == -1) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void given3Numbers_DeletionFromLast_fromTheAlreadyCreatedLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myThirdNode.getValue());
        myLinkedList.popLast();
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myThirdNode.getValue()) == -1) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void givenNumbers_inALinkedList_SearchTheValueInTheLinkedList(){
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myThirdNode.getValue());
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
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myFourthNode.getValue());
        myLinkedList.insert( thirdPosition, myThirdNode.getValue());
        System.out.println(myLinkedList);
        boolean result = (myLinkedList.getIndex(myThirdNode.getValue()) == thirdPosition) ? true : false;
        Assert.assertTrue(result);
    }

    @Test
    public void givenNumbersInTheLinkedList_DeletionAtTheMidPosition(){
        int thirdPosition = 2;
        Node<Integer> myFirstNode = new Node<>(56);
        Node<Integer> mySecondNode = new Node<>(30);
        Node<Integer> myThirdNode = new Node<>(40);
        Node<Integer> myFourthNode = new Node<>(70);
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>();
        myLinkedList.append(myFirstNode.getValue());
        myLinkedList.append(mySecondNode.getValue());
        myLinkedList.append(myFourthNode.getValue());
        myLinkedList.insert(thirdPosition, myThirdNode.getValue());
        System.out.println(myLinkedList + " Size: " + myLinkedList.size());
        myLinkedList.remove(thirdPosition);
        System.out.println(myLinkedList + " Size: " + myLinkedList.size());
        boolean result = (myLinkedList.getIndex(myThirdNode.getValue()) == thirdPosition) ? true : false;
        Assert.assertFalse(result);
    }

    @Test
    public void givenNumbersLinkedList_SortedLinkedListShouldBeProper(){
        CustomLinkedList<Integer> myLinkedList = new CustomLinkedList<>(9,8,7,5,3,1,4);
        String sortedLinkedList = "[1, 3, 4, 5, 7, 8, 9]";
        CustomLinkedList.sort(myLinkedList);
        String afterSorting_myLinkedList = myLinkedList.toString();
        Assert.assertEquals(sortedLinkedList, afterSorting_myLinkedList);
    }
}
