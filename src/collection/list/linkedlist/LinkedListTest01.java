package collection.list.linkedlist;


import java.util.Objects;

/**
 * @author gjd
 * @create 2021/9/26  21:27:27
 */
public class LinkedListTest01 {

    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node han = new Node("han");

        //连接三个结点
        jack.next = tom;
        tom.next = han;
        han.pre = tom;
        tom.pre = jack;

        //头指针first指向jack
        Node first = jack;
        //尾指针last指向han
        Node last = han;


        //在元素han的前面 添加一个对象
        Node smith = new Node("smith");

        han.pre = smith;
        tom.next =smith;

        smith.pre = tom;
        smith.next = han;


        //从头到尾开始遍历
        while(true){

            if(first == null)
                break;
            System.out.println(first);
            first = first.next;
        }

        System.out.println("=======================");
        //从尾到头进行遍历
        while(true){
            if(last == null)
                break;
            System.out.println(last);
            last = last.pre;
        }


    }
}

class Node{

    public Object item;
    public Node pre;  //指向前一个结点
    public Node next;   //指向后一个结点

    public Node(Object name){
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node="+item ;
    }
}