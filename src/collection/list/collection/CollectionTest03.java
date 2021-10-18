package collection.list.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest03 {

    public static void main(String[] args) {

        Collection c = new ArrayList();

        c.add(100);
        c.add(200);
        c.add(300);
        c.add(400);
        System.out.println(c);

        Iterator iterator = c.iterator();

        /**
         * 注意：当我们获取迭代对象后，就不能在使用集合中的删除方法对集合中的元素进行删除了，否则或报错
         *        需要删除元素，通过迭代器中的方法进行删除操作。
         */
        //c.remove(100);

        while (iterator.hasNext()) {

            Object object = iterator.next();

            if (object.equals(100)) {
                iterator.remove();
            }
        }
        System.out.println(c);
    }
}
