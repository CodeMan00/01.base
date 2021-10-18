package jdbc.jdbc1;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author gjd
 * @create 2021/9/27  22:25:04
 */
public class JDBCTest03 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);


        //得到执行sql语句的对象
        Statement statement = connection.createStatement();
        String sql = "select id,name,sex, borndate from actor";
        //返回结果
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){ //next()方法会把光标往后移动，如果没有更多的行，返回false

            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id +"\t"+ name +"\t"+sex+"\t"+date);
        }

        //关闭结果
        resultSet.close();
        statement.close();;
        connection.close();
    }
}
