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
            return;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = this.tail.getNext();
        }
        this.size++;
    }
}
