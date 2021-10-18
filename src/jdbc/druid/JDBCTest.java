package jdbc.druid;

import jdbc.utils.JDBCUtils;
import jdbc.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gjd
 * @create 2021/9/28  13:22:50
 *
 *
 */
public class JDBCTest {

    @Test
    public void test() throws SQLException {

        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection.getClass());
        //2.
        String sql = "select * from actor";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            String name = resultSet.getString(2);
            System.out.println(name);
        }

        //关闭资源
        JDBCUtilsByDruid.close(null,preparedStatement,connection);
    }
}
