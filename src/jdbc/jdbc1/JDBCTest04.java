package jdbc.jdbc1;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author gjd
 * @create 2021/9/27  22:53:17
 *
 * 演示sql注入，Statement无法处理sql注入，所以引出了PreparedStatement方法
 *
 *
 * PreparedStatement最大的好处就是在于重复使用同一模板，这样服务器只对SQL模板进行一次语法校验和函数编译，
 * 其中参数编译后都会成为函数的参数，执行SQL语句时只是把参数代入到函数中完成调用。这样就能赋予其不同的参数来重复的使用它，
 * 这就是提高效率的原因。此外预编译语句能防止 SQL 注入
 */
public class JDBCTest04 {

    //sql 注入   name输入  1' or
    //          sex输入  or '1' = '1
    private static String name;
    private static String sex;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的名字：");
        name = scanner.nextLine();
        System.out.print("请输入你的性别：");
        sex = scanner.nextLine();

        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);


        //得到执行sql语句的对象
        Statement statement = connection.createStatement();
        String sql = "select id,name,sex, borndate from actor where name ='"+name+"' and sex =' " + sex +"'";
        //返回结果
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){ //next()方法会把光标往后移动，如果没有更多的行，返回false
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        //关闭结果
        resultSet.close();
        statement.close();;
        connection.close();
    }
}
