package reflect;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 *  获取Method
 */
public class ReflectTest08 {

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> aClass = Class.forName("java.lang.String");
        String s = "abcdefg";

        Method[] methods = aClass.getDeclaredMethods();

//        for(Method method:methods){
//            System.out.println(method);
//        }

        //第一个参数是方法名   第二个参数是 参数的类型.class
        Method substring = aClass.getDeclaredMethod("substring", int.class);

        //方法的权限修饰符
        System.out.println(Modifier.toString(substring.getModifiers()));

        //获取方法参数的个数
        System.out.println(substring.getParameterCount());

        //获取方法的返回值类型
        Class<?> returnType = substring.getReturnType();
        System.out.println(returnType);

        //返回参数列表
        Parameter[] parameters = substring.getParameters();
        System.out.println(Arrays.toString(parameters));

        //返回参数类型列表
        Class<?>[] parameterTypes = substring.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        //调用方法   第一个参数是调用该方法的实例对象， 第二个参数是可变列表，用于存放参数的值
        System.out.println(substring.invoke(s, 2));

    }
}
