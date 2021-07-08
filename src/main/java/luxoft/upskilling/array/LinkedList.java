package luxoft.upskilling.array;

public class LinkedList implements List{

    Node head;

    static class Node{
        Object data;
        Node next;

        Node(Object d) {data = d; next = null;}
    }

    LinkedList(){}

    @Override
    public void add(Object value) {
        Node temp = head;
        Node node = new Node(value);
        if (size() != 0){
            head = node;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    @Override
    public void add(Object value, int index) {
        Node temp = head;
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Node node = new Node(value);

        if (size() == 0){
            head = node;
        }

        if(index == 0){
            node.next = head;
            head = node;
            return;
        }

        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        temp.next = node;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (size() == 0) throw new NullPointerException();
        if(index == 0){ head = head.next; return head.data; }
        Node temp = head, prev = null;

        int counter = 0;
        while (temp != null && counter != index){
            prev = temp;
            counter++;
            temp = temp.next;
        }
        if (temp == null){
            return -1;
        }
        prev.next = temp.next;
        return temp.data;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (size() == 0) throw new NullPointerException();
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
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (size() == 0) throw new NullPointerException();
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
}
