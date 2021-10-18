package scanner;

import java.util.Scanner;

/**
 * 1.Scanner :
 * 实现键盘输入数据到程序中
 * <p>
 * 2.引用其他类：
 * 1.导包：
 * 导入不同包下的其他类，注意：java.lang包下的类不需要导包，可以直接使用
 * 2.创建对象：
 * <p>
 * 3.使用
 * <p>
 * 3.Scanner 输入的数据都是字符串类型的，当我们需要其他的数据类型时，中间会发生
 * 转换，转换为我们需要的数据类型。
 */
public class ScannerTest01 {

    public static void main(String[] args) {

        //System.in代表从键盘进行输入
        Scanner scanner = new Scanner(System.in);

        //获取键盘输入的int类型的数据
        int num = scanner.nextInt();
        System.out.println("输入的数字是：" + num);


        //获取键盘输入的字符串
        String s = scanner.next();
        System.out.println("输入的字符串是：" + s);

    }
}
