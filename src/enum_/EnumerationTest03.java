package enum_;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gjd
 * @create 2021/9/26  19:08:17
 *
 * 演示Enumration的常用方法
 */
public class EnumerationTest03 {

    @Test
    public void test(){

        Seasonn season =Seasonn.AUTUMN;

        //输出枚举对象的名称
        System.out.println(season.name());

        //输出该枚举对象的次序/编号，从0开始编号
        System.out.println(season.ordinal());

        //获取定义的所有枚举对象，该方法被隐藏了，所以看不到，通过反编译可以看到
        Seasonn[] values = season.values();
        System.out.println(Arrays.toString(values));

        //将字符转换为枚举对象，要求字符串必须为已有的常量名，否则报异常
        Seasonn autumn = season.valueOf("AUTUMN");
        System.out.println(autumn);

        //比较两个枚举常量，比较的是编号,返回的是Seasonn.AUTUMN的编号减去Seasonn.SPRING的编号
        System.out.println(season.compareTo(Seasonn.SPRING));

        //如果子类修改了toString方法，那么返回修改后的结果，如果没有重写Enum类的toString方法
        //那么返回的就是调用toString方法的常量名，同name()的返回值相同。
        System.out.println(season.toString());
    }
}
