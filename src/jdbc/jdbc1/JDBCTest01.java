package jdbc.jdbc1;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author gjd
 * @create 2021/9/27  21:04:12
 *
 * jdbc为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。通过jdbc，可以连接
 * 任何提供了jdbc驱动程序的数据库文件，从而完成对数据库的操作。
 *
 * 编写步骤：
 *  1.注册驱动
 *  2.获取连接
 *  3.执行增删改查
 *  4.释放资源
 */
public class JDBCTest01 {

    public static void main(String[] args) throws SQLException {

        //1.注册驱动
        Driver driver = new Driver();

        /**
         * 2.得到连接
         *   1.jdbc:mysql:// 这是规定好的协议，通过jdbc的方式连接mysql
         *   2.localhost 主机，可以是ip地址
         *   3. 3306表示mysql监听的端口
         *   4.employees表示连接的数据库
         */
        String url = "jdbc:mysql://localhost:3306/myemployees";

        //将用户和密码放到properties文件中
        Properties properties = new Properties();
        /**
         *  user 和 password是规定好的。
         */
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Connection connect = driver.connect(url, properties);

        //3.执行sql语句
//        String sql = "insert into actor values(null,'张三','男','1999-06-01','110')";
//        String sql = "update actor set name = '周杰伦' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        //返回的是影响的行数
        int rows = statement.executeUpdate(sql);

        System.out.println(rows >0 ? "success" : "fail");

        //关闭资源
        statement.close();
        connect.close();

    }
}
