package com.bibichkov.datastructures;

import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;

public class ArrayList implements List {

    private static final int DEFAULT_SIZE = 5;

    private Object[] arrData;
    private int size = DEFAULT_SIZE;

    public ArrayList(){
        this(DEFAULT_SIZE);
    }

    public ArrayList(int index) {
        checkIndex(index, size);
        arrData = new Object[index];
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object newElement, int index) {
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


    @Override
    public Object remove(int index) {
        checkIndex(index, size -1);
        Object value = arrData[index];
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
    public Object set(Object value, int index) {
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
    public boolean contains(Object value) {
        boolean res = false;
        for (Object d : arrData){
            res = d.equals(value);
        }
        return res;
    }

    @Override
    public int indexOf(Object value) {
        int res = -1;
        for (int i = 0; i < size(); i++){
            if(arrData[i].equals(value)){
                res = i;
                break;
            }
        }
        return res;
    }

    @Override
    public int lastIndexOf(Object value) {
        int res = -1;
        for (int i = size() - 1; i >= 0; i--){
            if(arrData[i].equals(value)) res = i;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object d : arrData){
            sb.append(d);
        }
        sb.append("]");
        return sb.toString();
    }


    @VisibleForTesting
    public boolean containsAll(ArrayList arrayList){
        return Arrays.stream(arrData).allMatch(arrayList::contains);
    }

    private void checkIndex(int newIndex, int size) throws IndexOutOfBoundsException{
        if(newIndex < 0 || newIndex > size)
            throw new IndexOutOfBoundsException("Illegal index: " + newIndex);
    }

    private void trimToSize(){
        if(size < arrData.length){
            arrData = (size == 0) ? new Object[]{} : Arrays.copyOf(arrData, size);
        }
    }


}
