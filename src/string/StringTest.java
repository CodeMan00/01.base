package string;

import org.junit.Test;

/**
 * String 的基本用法
 * <p>
 * String对象一旦被创建就是固定不变的了，对String对象的任何改变都不影响到原对象，相关的任何change操作都会生成新的对象
 * <p>
 * 使用字符串常量池。每当我们创建字符串常量时，JVM会首先检查字符串常量池，如果该字符串已经存在常量池中，
 * 那么就直接返回常量池中的实例引用。如果字符串不存在常量池中，就会实例化该字符串并且将其放到常量池中。
 * 由于String字符串的不可变性我们可以十分肯定常量池中一定不存在两个相同的字符串
 * <p>
 * <p>
 * 常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。
 * 它包括了关于类、方法、接口等中的常量，也包括字符串常量
 * <p>
 * <p>
 * Java中的常量池，实际上分为两种形态：静态常量池和运行时常量池。
 * 所谓静态常量池，即*.class文件中的常量池，class文件中的常量池不仅仅包含字符串(数字)字面量，还包含类、方法的信息，占用class文件绝大部分空间。
 * 而运行时常量池，则是jvm虚拟机在完成类装载操作后，将class文件中的常量池载入到内存中，并保存在方法区中，我们常说的常量池，就是指方法区中的运行时常量池。
 * <p>
 * <p>
 * <p>
 * equals 和  ==
 * equals()是比较两个对象的值是否相等，这个对于String简单来说就是比较两字符串的Unicode序列是否相当，如果相等返回true;
 * 而==是比较两字符串的地址是否相同，也就是是否是同一个字符串的引用。
 * 对于基本数据类型： == 表示的是数值的比较    对于引用型比较的是地址
 * <p>
 * <p>
 * 构造方法：
 * 参数：1.无参数  2.字节数组  3.字符数组  4.Stringbuilder
 */
public class StringTest {

    //同样的字符串只保留一份
    @Test
    public void test() {

        String str1 = "aaa";
        String str2 = "aaa";
        // System.out.println(str1 == str2);

        //用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，它们有自己的地址空间。
        String str3 = new String("aaa");
        String str4 = new String("aaa");
        System.out.println(str1 == str3);

        //new 出来的对象都是新对象  不会相等的
        System.out.println(str3 == str4);

    }

    /**
     * ：因为str3指向堆中的"abcdef"对象，而"abcdef"是字符串池中的对象，所以结果为false。JVM对String str="abc"对象放在常量池中是在编译时做的
     * ，而String str3=str1+str2是在运行时刻才能知道的。new对象也是在运行时才做的。而这段代码总共创建了5个对象，
     * 字符串池中两个、堆中三个。+运算符会在堆中建立来两个String对象，这两个对象的值分别是"abc"和"def"，也就是说从字符串池中复制这两个值，
     * 然后在堆中创建两个对象，然后再建立对象str3,然后将"abcdef"的堆地址赋给str3。
     */
    @Test
    public void test02() {

        String s1 = "abc";
        String s2 = "def";
        String s3 = s1 + s2;
        System.out.println(s3 == "abcdef");
    }


    @Test
    public void test03() {

        String s = "abcdefghijklmnopqrstu";

//        int index = s.charAt('d');
//
//        s.concat("djasdk");
//
//        s.endsWith("asdf");
//
//        s.startsWith("fasdfa");
//
//        s.getBytes(); //返回字节数组
//
//        s.toLowerCase();
//
//        s.toUpperCase();
//
//        s.substring(1,5);  //1个参数表示从那个位置开始到最后
//
//        s.replace('a','c');
//
//        s.length();
//
//        s.equals("abc");

        //比较的是字符的个数，返回结果是s.length()-"abc".length的值
        // System.out.println(s.compareTo("abc"));

        s.compareToIgnoreCase("abc");

        s.equalsIgnoreCase("abc");

    }

    //字符串的查找
    @Test
    public void test04() {

        String s = "avbadsfasd";

        //首次出现的位置
        int index = s.indexOf('s');

        int index1 = s.indexOf("aaa");

        //从2位置开始往后查找
        int index2 = s.indexOf('a', 2);

        //最后一次出现的位置
        int index3 = s.lastIndexOf("aa");

    }

    @Test
    public void test05() {

        String s = "adfasefaest";

        //替换的是所有的a字符
        String str1 = s.replace('a', 'c');

        String str2 = s.replace("aaa", "bbb");

        //替换第一次出现的地方
        String str3 = s.replaceFirst("aaa", "bbb");
    }

    @Test
    public void test06() {

        String s = "aa  bb d\'a   ";
        String s1 = s.trim();
        s.length();

        s.contains("ab");

        //参数是定义分割符
        String[] strs = s.split(" ");

    }

    //基本数据类型转换为字符串
    @Test
    public void test07() {
        String s1 = String.valueOf(123);
        String s2 = String.valueOf(true);
        String s3 = String.valueOf(12.22);
    }


    //进制转换
    @Test
    public void test08() {

        String s1 = Long.toBinaryString(2);
        String s2 = Long.toOctalString(3);
        String s3 = Long.toHexString(6);
    }
}
