package com.bibichkov.datastructures;

public interface List<E> extends Iterable<E>{
    void add(E value);
    void add(E value, int index);
    E remove(int index);
    Object get(int index);
    Object set(E value, int index);
    void clear();
    int size();
    boolean isEmpty();
    boolean contains(E value);
    int indexOf(E value);
    int lastIndexOf(E value);
    String toString();
}
