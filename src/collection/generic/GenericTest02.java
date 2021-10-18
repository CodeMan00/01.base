package collection.generic;


import interfac_e.InterfaceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericTest02 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abdc");
        list.add("aac");
        list.add("de");

        ArrayList<Integer> lis1 = new ArrayList<>();
        lis1.add(1);
        lis1.add(15);
        lis1.add(13);
        lis1.add(12);

        test1(list);
        test1(lis1);

    }

    /**
     * ? 代表着不明确类型，  它和 T 是有去别的。
     * <p>
     * 如果是T,那么只能输入 一种数据类型  而 ？ 可以输入任意数据类型
     */
    public static void test1(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
