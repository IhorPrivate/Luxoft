package com.bibichkov.datastructures;

import com.google.common.annotations.VisibleForTesting;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_SIZE = 5;

    private Object[] arrData;
    private int size = DEFAULT_SIZE;

    public ArrayList(){
        this(DEFAULT_SIZE);
    }

    public ArrayList(int capacity) {
        checkIndex(capacity, size);
        arrData =  new Object[capacity];
    }

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E newElement, int index) {
        checkIndex(index, size);
        Object[] newArr = new Object[size + 1];
        if (size >= 0) {
            System.arraycopy(arrData, 0, newArr, 0, size);
        }
        arrData = newArr;
        if (size - index >= 0) {
            System.arraycopy(arrData, index, arrData, index + 1, size - index);
        }
        arrData[index] = newElement;
        size++;

    }


    // There is an only way to cast raw type to generic one, which is used in @java.utils.ArrayList too
    // The risk of inconsistency data in this case is minimum
    @Override
    public E remove(int index) {
        checkIndex(index, size -1);
        @SuppressWarnings("unchecked") E value = (E)arrData[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(arrData, index + 1, arrData, index, size - 1 - index);
        }
        arrData[size - 1] = null;
        size--;
        trimToSize();
        return value;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size));
        return arrData[index];
    }

    @Override
    public Object set(E value, int index) {
        if(index < 0 || index > size() - 1)
            throw new IndexOutOfBoundsException(String.format("Index should be between 0 to %2d", size()));
        arrData[index] = value;
        return value;
    }

    @Override
    public void clear() {
        if (size() > 0){
            Arrays.fill(arrData, 0, size, null);
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++){
            if(arrData[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size() - 1; i >= 0; i--){
            if(arrData[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[","]");
        for (Object data : arrData){
            stringJoiner.add(data.toString());
        }
        return stringJoiner.toString();
    }


    @VisibleForTesting
    public boolean containsAll(ArrayList<E> arrayList){
        if (arrayList.size() != size){
            return false;
        }

        if (arrayList.get(0) != arrData[0]){
            return false;
        }

        int i = 1;
        while (arrayList.iterator().hasNext()){
            if(arrData[i] != arrayList.iterator().next()){
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    @Nonnull
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && arrData[currentIndex] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) arrData[currentIndex++];
            }
        };
    }

    private void checkIndex(int newIndex, int size) throws IndexOutOfBoundsException{
        if(newIndex < 0 || newIndex > size)
            throw new IndexOutOfBoundsException("Illegal index: ");
    }

    private void trimToSize(){
        if(size < arrData.length){
            arrData = (size == 0) ? new Object[]{} : Arrays.copyOf(arrData, size);
        }
    }


}
