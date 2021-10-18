package jdbc.jdbc1;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gjd
 * @create 2021/9/28  09:40:16
 *
 * 事务：
 *      jdbc程序中当一个Connection对象创建时，默认情况下是自动提交事务：每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
 *      JDBC程序为了让多个sql语句作为一个整体执行，需要使用事务
 *      调用Connection的setAutoCommit(false)可以取消自动提交事务
 *      在所有的sql语句都成功执行后，调用commit；方法提交事务
 *      在其中某个操作失败或出现异常时，调用rollback()方法回滚事务
 *
 */
public class JDBCTest07 {


    @Test
    public void test() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtils.getConnection(); //connection 默认自动提交数据  执行一句提交一句

        String sql = "update account set balance = balance -100 where id =1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int rows1 = preparedStatement.executeUpdate();

        //让抛出异常 导致下面的代码不在执行
        int i = 1/0;
        int rows2= connection.prepareStatement(sql2).executeUpdate();


        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }


    @Test
    public void test1()  {
        //1.得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "update account set balance = balance -100 where id =1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        try {

            connection = JDBCUtils.getConnection();
            //设置为不自动提交 也可以理解为开启了事务
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            int rows1 = preparedStatement.executeUpdate();
            //让抛出异常 导致下面的代码不在执行
            //int i = 1/0;

            int rows2= connection.prepareStatement(sql2).executeUpdate();

            //手动提交事务
            connection.commit();
        } catch (SQLException throwables) {

            //如果出现异常，让其回滚
            try {
                //回滚到的地方 就是我们设置手动开启提交的地方  有个重载的方法，参数是回滚点，我们也可以设置回滚点。
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }


        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
