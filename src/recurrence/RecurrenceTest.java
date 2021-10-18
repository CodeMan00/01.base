package recurrence;

/**
 * 递归
 * <p>
 * 1.递归：方法自身调用自身
 * <p>
 * 2.递归非常耗费内存空间
 * <p>
 * 3.递归必须有结束条件，否则会栈溢出
 * <p>
 * 4.递归即使有了结束条件，即使结束条件是错误的，也可能发生栈内存
 * 溢出，因为递归的太深了
 * <p>
 * 注意：递归能不使用就不要使用
 */
public class RecurrenceTest {


    public static void main(String[] args) {

        //System.out.println("非递归方法："+test(10));

        System.out.println("递归方法：" + test01(10));
    }

    //不使用递归计算1-n的和
    public static int test(int n) {

        int sum = 0;
        for (int i = 0; i <= n; i++) {

            sum += i;
        }
        return sum;
    }


    //递归方法计算1-n的值
    public static int test01(int n) {
        if (n == 1) {
            return 1;
        }
        return n + test01(n - 1);
    }
}
