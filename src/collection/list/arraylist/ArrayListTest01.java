package collection.list.arraylist;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gjd
 * @create 2021/9/26  19:48:03
 *
 *  1.ArrayList中定义了一个Object类型的数组，Object [] elementData  可以存放任意类型的数据
 *  2.当创建对象时，如果使用了无参构造器，则初始化elementData的容量为0，第一次添加，则扩容elementData为10，
 *         如果要再次扩容，则扩容到elementData的1.5倍。
 *
 *  3.如果使用指定大小的构造器，则初始elementData的容量为指定大小，如果要再次扩容，则扩容到elementData的1.5倍。
 */
public class ArrayListTest01 {

    @Test
    public void test() {

        ArrayList list = new ArrayList();
        ArrayList test = new ArrayList(7);


        for (int i = 0;i<6;i++){
            test.add(i);
        }

        list.add(1);

        for (int i = 0; i < 10; i++) {
            list.add(i);

        }

        for(int i=10;i<15;i++){

            list.add(i);
        }

        for(int i = 15;i<20;i++){
            list.add(i);
        }
    }
}
