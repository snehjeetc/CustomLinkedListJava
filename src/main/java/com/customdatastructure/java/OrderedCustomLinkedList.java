package com.customdatastructure.java;

import java.util.Comparator;

public class OrderedCustomLinkedList<T> extends CustomLinkedList<T>{
    private Comparator<? super T> c;
    @SuppressWarnings("unchecked")
    public OrderedCustomLinkedList(Comparator<? super T> c, T ...vars) {
        super();
        this.c = c;
        if(vars == null || vars.length == 0 || vars[0] == null)
            return;

        super.add(vars[0]);

        int count = 1;
        while(count < vars.length) {
            int index = nextIndex(super.getHead(), vars[count], c);
            super.insert(index, vars[count]);
            count++;
        }
    }

    private static <T> int nextIndex(Node<T> head, T value, Comparator< ? super T> c) {
        if(head == null)
            return 0;
        int index = 0;
        while(head != null && c.compare(head.getValue(), value) < 0 ) {
            head = head.getNext();
            index++;
        }
        return index;
    }

    public void insert(T value) {
        int index = nextIndex(super.getHead(), value, c);
        super.insert(index, value);
    }

    @Override
    public void add(T value){
        insert(value);
    }

    @Override
    public void append(T value){
        insert(value);
    }

    @Override
    public void insert(int atIndex, T value) {
        throw new CustomLinkedListExceptions
                (CustomLinkedListExceptions.LinkedListExceptionType.UNSUPPORTED_OPERATION,
                        "Ordered linked list doesn't support insertion with index");
    }
}