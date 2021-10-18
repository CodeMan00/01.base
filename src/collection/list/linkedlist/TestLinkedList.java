package collection.list.linkedlist;


import org.junit.Test;

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.remove();
        list.set(0,4);
    }

    LinkedList list = new LinkedList();

    @Test
    public void test01() {

        list.add("java01");
        list.add("java02");
        list.add("java03");
        list.add("java04");


        //LinkedList特有的添加方法
        list.push("haha");
        list.addFirst("java07");
        list.addLast("java06");
        list.offerFirst("100");
        list.offerLast("200");

        //LinkedList特有的查询方法
        list.getFirst();
        list.getLast();
        list.peekFirst();
        list.peekLast();

        //LinkedList特有的删除方法   该方法返回被删除的元素，也可以当被获取元素的一种方式吧
        list.removeFirst();
        list.removeLast();
        list.pollFirst();
        list.pollLast();
        list.pop();
        list.removeFirstOccurrence("100");
        list.removeLastOccurrence("100");

    }

    //LinkedList 倒序取元素
    @Test
    public void test02() {
        list.add("java01");
        list.add("java02");
        list.add("java03");
        list.add("java04");

        while (!list.isEmpty()) {
            System.out.println(list.removeLast());
        }
    }
}
