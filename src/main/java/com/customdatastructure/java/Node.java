package com.customdatastructure.java;

public class Node<T> implements INode<T>{
    private T key;
    private Node<T> next;

    public Node(T key) {
        this.key = key;
        this.next = null;
    }

    public T getKey() {
        return this.key;
    }

    @Override
    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public INode<T> getNext(){
        return next;
    }

    @Override
    public void setNext(INode next) {
        this.next = (Node<T>) next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
