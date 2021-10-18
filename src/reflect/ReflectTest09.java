package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;

/**
 *   constructor
 */
public class ReflectTest09 {

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class clazz = Class.forName("reflect.Person");
        Constructor[] constructors = clazz.getDeclaredConstructors();

//        for(Constructor constructor : constructors){
//            System.out.println(constructor);
//        }

        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);

        //获取修饰符
        System.out.println(Modifier.toString(constructor.getModifiers()));

        //获取参数列表
        Parameter[] parameters = constructor.getParameters();
        System.out.println(Arrays.toString(parameters));

        //获取参数类型列表
        Class[] types = constructor.getParameterTypes();
        System.out.println(Arrays.toString(types));

        //调用构造方法实例化对象
        Object instance = constructor.newInstance("zhangsan", 12);
        System.out.println(instance);
    }
}
