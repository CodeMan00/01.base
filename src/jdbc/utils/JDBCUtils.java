package jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author gjd
 * @create 2021/9/28  05:28:28
 *
 * 这是一个工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {

    //
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    static{

        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        user = bundle.getString("user");
        password = bundle.getString("password");
        url = bundle.getString("url");
        driver = bundle.getString("driver");
    }

    public static Connection getConnection()  {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  需要关闭的资源：
     *      ResultSet、Statement、PreparedStatement、Connection
     */
    public static void close(ResultSet set,Statement statement,Connection connection ){


        try {
            if (set != null)
                set.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
