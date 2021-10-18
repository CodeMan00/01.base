package utils.collections;

/**
 * 静态导入：
 * import static静态导入是JDK 1.5增加的特性
 * 有两种使用方式： import static java.lang.Integer.*
 * 用.*时，表示导入类中的所有静态属性和方法。
 * <p>
 * import static java.lang.Integer.MAX_VALUE
 * 用静态名称时，表示只导入该静态属性或方法。
 * <p>
 * 好处：静态导入后就可以直接用名称访问静态属性和方法，而不必用ClassName.methodName()的方式来访问。
 * 其目的是为了减少字符输入量，提高代码的可阅读性，以便更好地理解程序。
 * <p>
 * 缺点：但是，滥用静态导入会使程序更难阅读，更难维护
 * <p>
 * <p>
 * 注意：
 * 如果使用某个静态方法时，这个静态方法中，有多个类中有这个方法，这些类可能不在同一包内，这是我们
 * 不能省略类名，否则，可能执行其他包中的类 中的这个方法。如：toString方法。
 * Object 有toString方法， Arrays也有这个方法。
 */

import org.junit.Test;

import static java.util.Calendar.*;

import java.util.Arrays;
import java.util.Calendar;

import static java.util.Arrays.*;

public class StaticImportTest {

    @Test
    public void test() {

        int[] a = {5, 1, 4, 6, 87, 12};

        //Arrays.sort(a);
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    @Test
    public void test02() {

        Calendar calendar = getInstance();

        int year = calendar.get(YEAR);
        int month = calendar.get(MONTH) + 1;
        int day = calendar.get(DATE);

    }
}
