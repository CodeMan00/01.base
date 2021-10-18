package collection.list.vector;


import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

public class TestVector {

    public static void main(String[] args) {
        Vector v = new Vector();

        for(int i = 0;i<10;i++){
            v.add(i);
        }
        v.add(1);
    }




    @Test
    public void test01() {
        Vector v = new Vector();
        v.add("java01");
        v.add("java02");
        v.add("java03");
        v.add("java04");


        //枚举就是Vector的特有的取出方式    枚举和迭代一样   只不过太长了，用迭代器替代了
        Enumeration enumeration = v.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
