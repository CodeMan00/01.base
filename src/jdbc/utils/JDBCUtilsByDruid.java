package jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author gjd
 * @create 2021/9/28  13:09:08
 *
 * 基于druid 数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource dataSource;

    //在静态代码块中，ds初始化
    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
    }

    //关闭连接，在数据库连接池中，close并不是真的断开连接，而是把Connection 对象放回连接池中
    public static void close(ResultSet set , Statement statement, Connection connection){

        try{
            if(set!=null)
                set.close();
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
