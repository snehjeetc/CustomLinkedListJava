package com.customdatastructure.java;

public class CustomLinkedListExceptions extends Exception {
    enum LinkedListExceptionType{
        LIST_EMPTY,
        INDEX_OUT_OF_BOUND;
    }
    LinkedListExceptionType type;
    public CustomLinkedListExceptions(LinkedListExceptionType type, String message){
        super(type.toString() + ": " + message);
        this.type = type;
    }
}
