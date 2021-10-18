package jdbc.jdbc1;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gjd
 * @create 2021/9/28  05:40:20
 */
public class JDBCTest06 {

    public static void main(String[] args) throws SQLException {

        //1.得到连接
        Connection connection = JDBCUtils.getConnection();

        //2.
        String sql = "update actor set name = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"张子健");
        preparedStatement.setInt(2,2);

        int i = preparedStatement.executeUpdate();

        System.out.println(i>0? "执行成功":"执行失败");

        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }

    @Test
    public void test1() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtils.getConnection();

        //2.
        String sql = "update actor set name = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"张子健");
        preparedStatement.setInt(2,2);

        int i = preparedStatement.executeUpdate();

        System.out.println(i>0? "执行成功":"执行失败");

        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }

    //完成select
    @Test
    public void test() throws SQLException {

        //1.得到连接
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection.getClass());

        //2.
        String sql = "select * from actor";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
        }

        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
