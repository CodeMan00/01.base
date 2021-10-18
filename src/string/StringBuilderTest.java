package string;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

/**
 * String 字符串常量
 * --》里面的字符数组是用final修饰的 所以不可变
 * <p>
 * StringBuilder  StringBuffer   字符串变量
 * --》 字符数组没被final修饰  可多次修改，不产生新的对象
 * <p>
 * 1.三者使用的场景
 * 操作少量数据用String
 * 单线程操作字符串缓冲区下 操作大量数据 StringBuilder  线程不安全
 * 多线程操作字符串缓冲区  操作大量数据StringBuffer   线程安全
 */

public class StringBuilderTest {

    @Test
    public void test() {

        //默认字符容量为16   也可以指定初始容量
        StringBuilder builder = new StringBuilder();

        //可插入基本数据类型  字符数组或片段  对象
        builder.append('a');
        builder.append("ab");
        builder.append(1);


        //第一个参数表示插入的初始位置
        builder.insert(1, "dede");

        System.out.println(builder);

    }

    //查询方法
    @Test
    public void test02() {

        StringBuilder builder = new StringBuilder("abcdefghigj");
        builder.charAt('c');

        builder.indexOf("fa");
        builder.indexOf("fa", 1);

        builder.lastIndexOf("ds");
        builder.lastIndexOf("aa", 1);
    }

    //其他方法
    @Test
    public void test03() {

        StringBuilder builder = new StringBuilder("ASDFASDF");

        //换掉某子串
        builder.replace(1, 2, "ttt");

        //截取字串   可以只有一个参数
        builder.substring(1, 3);

        //颠倒
        builder.reverse();

        //修改指定位置上的字符
        builder.setCharAt(1, 'b');

        //长度  注意和容量的区别
        builder.length();

        //返回字符串
        builder.toString();
    }
}
