package reflect;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *  通过Class对象获取成员方法、成员变量、构造方法
 */
public class ReflectTest05 {

    /**
     * 获取成员变量
     */
    @Test
    public void test() throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("reflect.Person");
        //获取所有的被public修饰的成员变量
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            System.out.println(field);
        }

        //根据指定字段获取public成员   如果获取的成员不是public修饰的，抛出NoSuchFieldException
        Field sex = clazz.getField("age");
        System.out.println(sex);


        //获取所有的成员 变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field);
        }


        //根据指定的变量名获取指定的成员
        System.out.println(clazz.getDeclaredField("username"));
    }


    //Field常用的方法
    @Test
    public void test01() throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("reflect.Person");

        Field username = clazz.getDeclaredField("username");

        //字段的名称
        String name = username.getName();
        //字段的类型
        Class<?> type = username.getType();

        //获取成员变量的修饰符
        String s = Modifier.toString(username.getModifiers());

        System.out.println(s);

        System.out.println(username.equals("AAAA"));
    }


    /***
     *   通过反射操作实例对象的属性值
     */

    @Test
    public void test03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Person person = new Person();
        person.age =10;

        Class clazz = Class.forName("reflect.Person");
        Person person1 = (Person) clazz.newInstance();
        Field age = clazz.getDeclaredField("age");

        age.set(person,100);
        //获取对象的属性值
        System.out.println("获取PERSON1实例对象的属性值："+age.get(person));

        //不是同一个对象
        System.out.println(person == person1);

        //可以对已经创建的对象进行属性修改
        System.out.println(person.age);

        //访问私有成员变量
        Field username = clazz.getDeclaredField("username");
        username.setAccessible(true); //打破封装,这是反射机制的缺点
        username.set(person1,"jack");
        System.out.println("persno1的username="+username.get(person1));
    }
}
