package scanner;

import org.junit.Test;

import java.util.Scanner;

/**
 * 题目：键盘输入两个int数字，并且求出和
 */


/**
 * 匿名对象
 * 1.匿名对象:没有名字的对象
 *
 * 2.定义格式:new 类名
 *
 * 3.匿名对象的使用场景
 *      1.如果一个对象只用一次可以尝试使用匿名对象,这样可以节省一些内存,没有东西指向它,优先被GC回收
 *      2.可以当做某个方法的实参进行传递
 *      3.可以作为方法的返回值进行返回
 *
 * 4.匿名对象的好处
 * 节省内存,容易被GC回收,匿名对象可以对属性赋值但毫无意义,但凡是引用数据类型能使用的,匿名对象也能使用
 */
public class ScannerTest02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();

        //注意：如果在输入语句中，没有把num1+num2用小括号括起来，它们和字符串相加
        //会形成字符串之间的相加，而不是数字相加
        //       System.out.println("它们的和为："+(num1+num2));

        test();

    }

    /**
     * next() 读取空格或换行前面的内容   字符串中不可包含空格
     *
     * nextLine() 读取一行内容 并返回   字符串中可包含空格
     *
     *
     * 注意：nextLine()自动读取了被next()去掉的Enter作为他的结束符，所以没办法给s2从键盘输入值。
     * 解决办法：在next()之后加一个nextLine()语句，将被next()去掉的Enter结束符过滤掉。
     */
    public static void test() {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.nextLine();
        System.out.println(s);

        String s1 = scanner.nextLine();
        System.out.println(s1);
    }
}
