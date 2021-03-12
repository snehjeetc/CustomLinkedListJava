package com.customdatastructure.java;

public class CustomLinkedList {

    private  INode head;
    private INode tail;
    private int size;

    public CustomLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void add(INode newNode) {
        if(this.head == null)
            this.tail = this.head = newNode;
        else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    private String convToString(INode head) {
        if(head.getNext() == null)
            return head.getKey().toString();
        return head.getKey().toString() + "-> " + convToString(head.getNext());
    }

    @Override
    public String toString() {
        if(this.head == null)
            return "";
        return "[" + convToString(this.head) + "]";
    }

    public INode getHead(){
        return head;
    }

    public INode getTail(){
        return tail;
    }

    public void append(INode newNode) {
        if(this.head == null) {
            this.tail = this.head = newNode;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = this.tail.getNext();
        }
        this.size++;
    }

    public int getIndex(INode node) {
        if(this.head == null) {
            return -1;
        }
        int index = 0;
        INode temp = this.head;
        while(temp != null) {
            if(temp.equals(node))
                return index;
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public <T> int getIndex(T key) {
        if(this.head == null) {
            return -1;
        }
        int index = 0;
        INode temp = this.head;
        while(temp != null) {
            if(temp.getKey().equals(key))
                return index;
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public void insert(INode newNode, int atIndex) throws CustomLinkedListExceptions {
        if(this.head == null && atIndex!=0) {
            throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND, "Invalid index for insertion");
        }
        if(atIndex == 0) {
            add(newNode);
            return;
        }
        int count = 0;
        INode temp = this.head;
        while(temp.getNext()!=null && count < atIndex-1) {
            temp = temp.getNext();
            count++;
        }
        if(temp.getNext() != null) {
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.size++;
            return;
        }
        else if(temp.getNext() == null && count == atIndex-1) {
            append(newNode);
            return;
        }
        else {
           throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND, "Invalid index for insertion");
        }
    }

    public void pop() {
        if(this.head != null) {
            if(this.head == this.tail)
                this.tail = this.head = null;
            else {
                INode temp = this.head;
                this.head = this.head.getNext();
                temp.setNext(null);
            }
            this.size--;
        }
    }

    public void popLast() {
        if (this.head == null)
            return;
        if (this.head.getNext() == null) {
            this.head = this.tail = null;
            this.size--;
            return;
        }
        INode prevTail = this.head;
        while (prevTail.getNext() != this.tail)
            prevTail = prevTail.getNext();
        prevTail.setNext(null);
        this.tail = prevTail;
        this.size--;
    }

    public <T> boolean search(T value) {
        return getIndex(value) != -1;
    }

    public int length(){
        return this.size;
    }

    public void remove(int atIndex) {
        if(this.head == null) {
            return;
        }
        if(atIndex == 0) {
            this.pop();
            return;
        }
        INode temp = this.head;
        INode prevTail = null;
        int count = 0;
        while(temp != null && count < atIndex) {
            prevTail = temp;
            temp = temp.getNext();
            count++;
        }
        if(temp != null) {
            prevTail.setNext(temp.getNext());
            if(temp == this.tail)
                this.tail = prevTail;
            temp.setNext(null);
            this.size--;
            return;
        }
        else {
            throw new CustomLinkedListExceptions(CustomLinkedListExceptions.LinkedListExceptionType.INDEX_OUT_OF_BOUND, "Invalid index for removal");
        }
    }
}
