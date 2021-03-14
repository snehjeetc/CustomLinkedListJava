package com.customdatastructure.java;

import org.junit.Assert;
import org.junit.Test;

public class OrderedCustomLinkedListTestClass {
    @Test
    public void givenNumbers_LinkedListConstructedShouldBeOrdered(){
        OrderedCustomLinkedList<Integer> myIntegerList = new
                OrderedCustomLinkedList<>(Integer::compare, 9,8,2,4,6,1);
        String expectedList = "[1, 2, 4, 6, 8, 9]";
        String constructedList = myIntegerList.toString();
        Assert.assertEquals(expectedList, constructedList);
    }

    @Test
    public void givenStrings_LinkedListConstructedShouldBeOrdered(){
        OrderedCustomLinkedList<String> myStringList = new
                OrderedCustomLinkedList<String>((a, b)->a.compareTo(b), "ZZZ", "AAA", "DDD", "CCC");
        String expectedList = "[AAA, CCC, DDD, ZZZ]";
        String constructedList = myStringList.toString();
        Assert.assertEquals(expectedList, constructedList);
    }

    @Test
    public void givenNumbers_ConstructOrderedLinkedList_InsertNumberInCorrectPosition(){
        OrderedCustomLinkedList<Integer> myIntegerList = new
                OrderedCustomLinkedList<>(Integer::compare, 9,8,2,4,6,1);
        Integer toBeInserted = 5;
        myIntegerList.insert(toBeInserted);
        Integer expectedIndexAfterInsertion = 3;
        Assert.assertEquals(expectedIndexAfterInsertion, (Integer)myIntegerList.getIndex(toBeInserted));
    }

    @Test
    public void givenEmptyOrderedLinkedList_Add4Numbers_ShouldReturnProperOrderedLinkedList(){
        OrderedCustomLinkedList<Integer> myIntegerList = new OrderedCustomLinkedList<>(Integer::compare);
        myIntegerList.insert(Integer.valueOf(7));
        for(int i=4; i>0; i--)
            myIntegerList.insert(Integer.valueOf(i));
        String expectedCustomLinkedList = "[1, 2, 3, 4, 7]";
        String constructedList = myIntegerList.toString();
        System.out.println(myIntegerList);
        Assert.assertEquals(expectedCustomLinkedList, constructedList);
    }
}
