package io.stream;

import org.junit.Test;

import java.io.*;

/***
 *   对象都是存储在堆内存中，当程序运行完后，内存就释放了，对象也就消失了，
 *   我们可以通过流的方式，将对象存在硬盘上。
 */
public class ObjectInputStreamTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {


        //ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("d://obj.txt"));
//      writeObject方法就是对 对象进行序列化，实现Seri那个接口，只是让对象具备可序列化的属性
        //obj.writeObject(new Person("lisi",12));


        ObjectInputStream obinput = new ObjectInputStream(new FileInputStream("d://obj.txt"));
        // readObject() 实现的是对象的反序列化
        Person person =(Person) obinput.readObject();
        System.out.println(person);

        //obj.close();
        obinput.close();
    }
}

/**
 * 一、序列化的含义、意义及使用场景
 *
 *      序列化：将对象写入到IO流中
 *      反序列化：从IO流中恢复对象
 *
 *      意义：序列化机制允许将实现序列化的Java对象转换为字节序列，这些字节序列可以保存在磁盘上，
 *      或通过网络传输，以达到以后恢复成原来的对象。序列化机制使得对象可以脱离程序的运行而独立存在。
 *
 *      使用场景：所有可在网络上传输的对象都必须是可序列化的，比如RMI（remote method invoke,即远程方法调用），
 *      传入的参数或返回的对象都是可序列化的，否则会出错；所有需要保存到磁盘的java对象都必须是可序列化的。
 *
 *      通常建议：
 *          程序创建的每个JavaBean类都实现Serializeable接口。
 *
 *
 * 二、序列化实现的方式
 *      如果需要将某个对象保存到磁盘上或者通过网络传输，那么这个类应该实现Serializable接口或者Externalizable接口之一。
 *
 */
class Person implements Serializable {

    private String name;
    private int age;

   public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

