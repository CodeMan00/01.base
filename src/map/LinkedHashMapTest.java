package map;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap
 * 有序，不重复   Key重复会覆盖、Value允许重复   非线程安全
 * Key和Value都允许空
 */
public class LinkedHashMapTest {

    @Test
    public void test() {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("1", "a");
        map.put("2", "d");
        map.put("3", "aeb");
        map.put("4", "ae");
        map.put("15", "ya");


        System.out.println(map);
    }
}
