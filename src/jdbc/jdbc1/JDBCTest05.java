package jdbc.jdbc1;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.*;
import java.util.Date;

/**
 * @author gjd
 * @create 2021/9/27  23:09:42
 *
 * 预处理PreparedStatement语句的好处:
 *          1.不在使用 + 拼接sql语句，减少了语法的错误
 *          2.有效的解决了sql注入问题
 *          3.大大减少了编译次数，效率提高。
 */
@SuppressWarnings({"all"}) //表示不显示任何警告
public class JDBCTest05 {

    //sql 注入   name输入  1' or
    //          sex输入  or '1' = '1
    private static String admin;
    private static String pwd;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException, ParseException {


        //sql 注入   name输入  1' or
        //          sex输入  or '1' = '1
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入管理员名字：");
        admin = scanner.nextLine();
        System.out.print("请输入管理员密码：");
        pwd = scanner.nextLine();

        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection( url, user, password);

        //？表示占位符
//        String sql = "select * from actor where name = ? and sex = ? ";
        String sql = "insert into admin values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //查询：给 ？ 赋值
//        preparedStatement.setString(1,name); //第一个参数代表第几个？,从1开始计数   第二个参数就是要赋的值
//        preparedStatement.setString(2,sex);

        //添加：
        preparedStatement.setString(1,admin);
        preparedStatement.setString(2,pwd);

        //执行查询时，不需要在写sql语句
        int rows = preparedStatement.executeUpdate();

        System.out.println(rows>0 ? "插入成功!":"插入失败！");

        //关闭资源
        preparedStatement.close();
        connection.close();
    }
}
