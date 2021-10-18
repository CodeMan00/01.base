package overload;

/**
 * 方法的重载
 * <p>
 * 方法名相同，参数的个数或类型或返回值类型可以不同
 */
public class OverloadTest {

    public static void main(String[] args) {

        test(1);
        test(1.0);
        test("zhang");
        test();
    }

    public static int test(int a) {
        return a * 10;
    }

    public static double test(double a) {
        return a * 10.0;
    }

    public static String test(String string) {
        return string;
    }

    public static void test() {
        System.out.println("方法的重载");
    }
}
