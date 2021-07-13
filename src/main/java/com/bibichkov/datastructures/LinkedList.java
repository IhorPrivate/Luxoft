package com.bibichkov.datastructures;

public class LinkedList implements List{

    Node head;



    public LinkedList(){}

    @Override
    public void add(Object value) {
        add(value, size()-1);
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size()));
        Node node = new Node(value);

        if (head == null){
            head = node;
        }
        Node temp = head;

        int counter = 0;

        while (temp != null || counter != index){
            temp = temp.next;
            counter++;
        }




    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size()));
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

        if (temp.next == null)



        if (temp == null){
            return -1;
        }
        return temp.data;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size()));
        if (size() == 0) throw new NullPointerException("Array is empty");
        if(index == 0){ return head.data; }
        Node temp = head;

        int counter = 0;
        while (temp != null && counter != index){
            counter++;
            temp = temp.next;
        }

        if (temp == null){
            return -1;
        }

        return temp.data;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size()));
        if (size() == 0) throw new NullPointerException("Array is empty");
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

    private static class Node{
        private Object data;
        private Node next;
        private Node prev;

        Node(Object d) {
            data = d;
            next = null;
            prev = null;
        }
    }
}
