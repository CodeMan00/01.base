package integer;


/**
 * 基本数据类型的包装类
 * <p>
 * byte Byte
 * short Short
 * int  Integer
 * long Long
 * float Float
 * double Double
 * char Character
 * boolean Boolean
 */
public class TestInteger01 {

    public static void main(String[] args) {

        //test01();
        // test02();
        test03();
    }

    public static void test01() {

        //整数类型的最大值
        System.out.println(Integer.MAX_VALUE);
    }


    public static void test02() {

        //基本数据类型转换为字符串   1. +" "  2.toString()

        //字符串转换为基本数据类型  语法： xxx a = Xxx.parseXxx
        int num = Integer.parseInt("123");
        long lon = Long.parseLong("123");

        System.out.println(lon + 2);
        System.out.println(num + 2);


        //转换为二进制
        System.out.println(Integer.toBinaryString(6));
        //转换为八进制
        System.out.println(Integer.toOctalString(8));
        //转换为哈希值
        System.out.println(Integer.toHexString(15));


        //其他进制转换为十进制    第一参数是代转换的数据  第二个参数是转成几进制
        System.out.println(Integer.parseInt("110", 2));
    }


    public static void test03() {

        Integer m = 128;
        Integer n = 128;
        System.out.println("m=n:" + (m.equals(n)));


    }

    public static void test() {


    }
}
