package utils.date;

import org.junit.Test;

import java.net.SocketImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.DateFormat
 * 作用：
 * 格式化：日期-->文本    解析：文本 --> 日期
 * <p>
 * <p>
 * 构造方法：
 * SimpleDateFormat(String pattern)
 * 参数模式：
 * 年  y 、 月 M 、日 d 、时 H 、 分 m 、秒 s
 */
public class DateFormatTest {

    //格式化日期形式   最终转换为String类型
    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }


    //转换为Date类型
    @Test
    public void test01() throws ParseException {

        SimpleDateFormat simpleDateFormat = new
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //如果字符串和构造方法中的模式不匹配，则抛出异常
        Date parse = simpleDateFormat.parse("2021-09-21 20:55:38");

        System.out.println(parse);
    }
}
