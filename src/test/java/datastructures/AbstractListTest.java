package datastructures;

import com.bibichkov.datastructures.ArrayList;
import com.bibichkov.datastructures.List;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {


    private final List<String> list = getStringList();

    abstract List<String> getStringList();


    @Test
    @Description("test add value to the end of the list")
    public void addValueToEndListTest(){
        String expected = "String1";
        int index = 5;

        list.add(expected);
        Object actual = list.get(index);

        assertEquals(expected, actual, "The last element was not added properly");
    }

    @Test
    @Description("test add value to the end of the list with wrong index exception throws")
    public void throwsIndexIndexOutOfBoundsExceptionWhenIndexWrongTest(){
        String stringToAdd = "String1";
        int index = 6;

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(stringToAdd, index));
    }

    @Test
    @Description("test remove element by index to test content of result list")
    public void removeElementByIndexProperlyListContent(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("String2");

        int removeElementIndex = 5;

        list.add("String1");
        list.add("String2");
        list.remove(removeElementIndex);

        ArrayList<String> actual = (ArrayList<String>) list;
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual)
                        && actual.containsAll(expected), "Element by index wasn't remove properly");
    }
/*
    // we can remove value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException

    // [A, B, C] remove = 0
    // [B (index = 0) , C (index = 1)]
    Object remove(int index);

    // [A, B, C] size = 3
    // we can get value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    Object get(int index);

    // we can set value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    Object set(Object value, int index);

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    // [A, B, A, C] indexOf(A) -> 0
    // -1 if not exist
    int indexOf(Object value);

    // [A, B, A, C] lastIndexOf(A) -> 2
    int lastIndexOf(Object value);

    // [A, B, C]
    String toString();
    */

    private ArrayList<String> fillListData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String1");
        arrayList.add("String2");
        return arrayList;
    }

}
