package luxoft.upskilling.array;

import java.util.Arrays;

class ArrayList implements List {

    private static final int DEFAULT_SIZE = 10;

    private final Object[] data;

    public ArrayList(int size) {
        if (size < 0) throw new IndexOutOfBoundsException();
        data = new Object[size];
    }

    public ArrayList(){
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(Object value) {
        add(value, 0);
    }

    @Override
    public void add(Object value, int index) {
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Object[] result = new Object[size()];
        System.arraycopy(data, 0, result, 0, index);
        result[index] = value;
        if (size() - 1 >= 0)
            System.arraycopy(data, index, result, index+1, size() - index);

        System.arraycopy(result, 0, data, 0, size());

    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        Object[] result = new Object[size()-1];
        System.arraycopy(data, 0, result, 0, index);
        if (size() - 1 >= 0)
            System.arraycopy(data, index+1, result, index, size() - index-1);

        return Arrays.stream(result).toArray(Object[]::new);
    }



    @Override
    public Object get(int index) {
        if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        data[index] = value;
        return value;
    }

    @Override
    public void clear() {
        if (size() > 0){
            Arrays.fill(data, 0, size(), null);
        }
    }

    @Override
    public int size() {
        int count = 0;
        while (data[count] != null){
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object value) {
        boolean res = false;
        for (Object d : data){
            res = d.equals(value);
        }
        return res;
    }

    @Override
    public int indexOf(Object value) {
        int res = -1;
        for (int i = 0; i < size(); i++){
            if(data[i].equals(value)){
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
            if(data[i].equals(value)) res = i;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object d : data){
            sb.append(d);
        }
        sb.append("]");
        return sb.toString();
    }

}
