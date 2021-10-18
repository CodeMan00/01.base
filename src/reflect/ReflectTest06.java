package reflect;

import interfac_e.InterfaceTest;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 *
 *  演示字节码对象Clazz的常用方法
 */
public class ReflectTest06 {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("java.lang.String");

        //获取类修饰符
        System.out.println(Modifier.toString(clazz.getModifiers()));

        //获取指定资源 并转换为字节流
        clazz.getResourceAsStream("");

        //获取类名  只是类名 不包含包名
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);

        //获取包名
        System.out.println(clazz.getPackage());

        //创建一个实例对象
        clazz.newInstance();

        //获取父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass.getName());

        //获取所有父接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c :interfaces){
            System.out.println(c.getSimpleName());
        }


        //获取父类   如果父类定义了泛型，返回结果中，包含父类的泛型
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());

        //获取父接口，如果父接口定义了泛型，返回结果中 包含父接口的泛型
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for(Type  type : genericInterfaces){
            System.out.println(type.getTypeName());
        }
    }
}
