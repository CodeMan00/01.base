package collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 去除ArrayList中的重复元素
 */
public class TestArrayList {

    public static void main(String[] args) {

    }

    public ArrayList match(ArrayList list) {

        ArrayList list1 = new ArrayList();

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Object object = iterator.next();

            if (!list1.contains(object)) {
                list1.add(object);
            }
        }
        return list1;
    }
}

class Test {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(100);
        list.add(100);
        list.add(200);
        list.add(34);
        list.add(41);
        list.add(98);
        TestArrayList testArrayList = new TestArrayList();

        ArrayList list2 = testArrayList.match(list);
        System.out.println(list2);
    }
}