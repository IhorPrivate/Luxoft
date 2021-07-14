package datastructures;

import com.bibichkov.datastructures.ArrayList;
import com.bibichkov.datastructures.List;


public class ArrayListTest extends AbstractListTest{


    @Override
    List<String> getStringList() {
        return new ArrayList<>();
    }


}
