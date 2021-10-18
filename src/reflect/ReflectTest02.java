package reflect;

import org.junit.Test;

public class ReflectTest02 {

    @Test
    public void test(){

        try {
            Class<?> aClass = Class.forName("reflect.Person");

            /**
             *  通过newInstatnce方法实例化对象
             *  注意：
             *      该方法只能通过无参构造方法实例化对象，如果没有定义无参构造方法，则抛出InstantiationException
             */
            Person user = (Person) aClass.newInstance();

            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class User{

    private String username;
    public int age;
    String sex;
    protected boolean flag;
    static String country ;



    public User(String username){

        System.out.println("username 的有参构造方法");
    }
}
