package jdbc.jdbc1;

import com.mysql.jdbc.Driver;
import com.sun.deploy.panel.IProperty;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author gjd
 * @create 2021/9/27  21:40:33
 */
public class JDBCTest02 {

    //方式一 使用反射机制
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        //通过反射加载Driver类，动态加载，更加灵活，减少依赖性。
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();;

        String sql = "jdbc:mysql://localhost:3306/myemployees";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        //获取连接
        Connection connect = driver.connect(sql, properties);

        System.out.println(connect);
    }

    //方式二  ： 通过DriverManager 替代Driver 进行统一管理
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //创建url
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String user = "root";
        String password = "123456";

        //注册Driver驱动
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式三  使用Class.forName 自动完成驱动，简化代码 ； 这种方式使用的最多。
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        //其实在java1.5以后，使用了jdbc4，不在需要显示调用class.forName()注册驱动而是自动
        // 调用驱动jar包下META-INF\service\java.sql.Driver文本中的类名称去注册。但是还是建议写上。

        //在加载类时，完成注册
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/myemployees";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    //第四种方式：通过配置文件读取 url、user、root等信息
    @Test
    public void test03() throws SQLException, IOException, ClassNotFoundException {

//        Properties properties = new Properties();
//        properties.load(new FileInputStream("src\\mysqlConfig.properties"));
//        String driver1 = properties.getProperty("driver");


        ResourceBundle bundle = ResourceBundle.getBundle("mysqlConfig");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    //方式五.  不推荐使用
    @Test
    public void test4() throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/myemployees";
        //将用户和密码放到properties文件中
        Properties properties = new Properties();
        /**
         *  user 和 password是规定好的。
         */
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);
    }
}
