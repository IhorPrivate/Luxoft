package com.bibichkov.datastructures;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<E> implements List<E>{

    private Node<E> head;

    private Node<E> tail;

    private int size;


    public LinkedList(){}

    @Override
    public void add(E value) {
        add(value, size()-1);
    }

    @Override
    public void add(E value, int index) {
        checkIndexForNewData(index);
        if (index == size){
            final Node<E> last = tail;
            Node
            tail =
        }

        if(tail == null){
            head =
        }


        if (head == null){
            head = node;
        }
        Node<E> temp = head;

        int counter = 0;

        while (temp != null && counter != index){
            temp = temp.next;
            counter++;
        }

    }





    @Override
    public E remove(int index) {
        checkIndexForExistedData(index, size);
        if (size() == 0) throw new NullPointerException("Array is empty");

        if (index == 0){
            head = head.next;
            return head.data;
        }

        Node temp = head;

        int counter = 0;
        while (temp.next != null || counter != index){
            temp = temp.next;
            counter++;
        }

        //if (temp.next == null)


//
//        if (temp == null){
//            return -1;
//        }
//        return temp.data;
            return null;
    }

    @Override
    public E get(int index) {
        checkIndexForExistedData(index, size);
        if (size == 0){
            throw new NullPointerException("Array is empty");
        }

        if(index == 0){ return head.data; }
        Node<E> temp = head;

        while (temp != null){
            if()
            temp = temp.next;
        }

        if (temp == null){
            return -1;
        }

        return temp.data;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndexForExistedData(index, size);
        if (size == 0) throw new NullPointerException("Array is empty");
        if(index == 0){
            head.data = value;
            return head.data;
        }

        Node temp = head;

        int counter = 0;
        while (temp != null && counter != index){
            counter++;
            temp = temp.next;
        }

        if (temp == null){
            return -1;
        }

        temp.data = value;
        return temp.data;
    }

    private void checkIndexForExistedData(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size));
    }

    private void checkIndexForNewData(int index) {
        if (index <= 0 || index > size)
            throw new IndexOutOfBoundsException(String.format("Index should be between 1 to %2d", size));
    }

    @Override
    public void clear() {
        while (head != null){
            head = head.next;
        }
    }

    @Override
    public int size() {
        Node temp = head;
        if (temp == null){
            return 0;
        }
        int count = 0;
        while (temp.next != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node temp = head;
        while (temp.next != null){
            if (temp.data.equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node temp = head;
        int counter = 0;
        while (temp.next != null){
            counter++;
            if (temp.data.equals(value)){
                return counter;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node temp = head;
        int counter = 0, pos = 0;
        while (temp.next != null){
            counter++;
            if (temp.data.equals(value)){
                pos = counter;
            }
        }
        return pos;
    }

    @Override
    public String toString() {
        Node temp = head;
        StringJoiner stringJoiner = new StringJoiner(",", "[","]");
        while (temp){
            stringJoiner.add(data.toString());
        }
        return stringJoiner.toString();
    }


    @Override
    @Nonnull
    public Iterator<E> iterator() {
        return new Iterator<>() {

            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E result = current.data;
                current = current.next;
                return result;
            }
        };
    }

    private void linkLast(E e){
        final Node<E> l = tail;


    }

    private static class Node<E>{
        private E data;
        private final Node<E> next;
        private final Node<E> prev;

        Node(Node<E> prev, E d, Node<E> next) {
            data = d;
            this.next = next;
            this.prev = prev;
        }
    }
}
