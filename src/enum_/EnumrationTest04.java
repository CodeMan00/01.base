package enum_;

import org.junit.Test;

/**
 * @author gjd
 * @create 2021/9/26  19:27:05
 *
 *  任务：
 *    声明Week枚举类，其中包括周一到周日的定义，使用values返回所有的枚举数组，并遍历。
 */
public class EnumrationTest04 {

    @Test
    public void test(){

        Week[] values = Week.values();

        System.out.println("====所有的信息如下===");
        for(Week value :values){
            System.out.println(value);
        }
    }
}

enum Week{

    MONEY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),TURESDAY("星期四"),FRIDAY("星期五"),
    SATURDAY("星期六"),SUNDAY("星期日");

    private final String name;
    Week(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}