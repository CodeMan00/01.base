package jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author gjd
 * @create 2021/9/28  11:56:16
 *
 * 数据库连接池：
 *      1.预先再缓冲区放入一定数量的连接，当需要建立数据库连接时，只需从”缓冲池“中取出一个，使用完毕后再归还。
 *      2.数据库连接池，负责分配，管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重新创建
 *      3。当应用程序向数据库连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中。
 *
 *   好处：
 *      1.避免了重复创建和重复销毁的开销
 *      2.提高了系统的响应速度
 *      3.统一的管理，避免数据连接泄露
 *
 *
 * 演示C3PO的使用
 */
public class C3P0Test {


    @Test
    public void test() throws PropertyVetoException, SQLException {

        //1.创建数据源对象(连接池)
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //2.通过配置文件拿到连接的信息
        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("driver");

        //给数据源 设置相关的参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //测试连接池的效率，测试对mysql 获取连接5000次操作所消耗的时间
        long begin = System.currentTimeMillis();
        for(int i =0;i<5000;i++){
            //获取连接
            Connection connection = comboPooledDataSource.getConnection();
            //关闭连接
            connection.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("c3p0 5000次连接数据库所消耗的时间："+(end-begin));
    }


    //第二种方式：通过配置文件模板来获取连接
      //1.将c3p0 的配置文件放到src目录下,且文件名必须是c3p0-config.xml
    //2.该文件制定了连接数据库和连接池的相关参数

    @Test
    public void test1() throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource("dataSource");
        long begin = System.currentTimeMillis();
        for(int i =0;i<500000;i++){
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 500000次连接数据库所消耗的时间："+(end-begin));
       // System.out.println("连接成功");
    }
}
