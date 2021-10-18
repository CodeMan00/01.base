package jdbc.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author gjd
 * @create 2021/9/28  12:36:47
 *
 * 测试Druid(德鲁伊)
 */
public class DruidTest {

    @Test
    public void test() throws Exception {

        //1.引入Druid jar包
        //2.加入配置文件 druid.properties  将文件拷贝到项目的src目录

        //3.创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5.获取Connection
        long begin = System.currentTimeMillis();
        for(int i =0;i<500000;i++){
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end-begin));
        //System.out.println("连接成功");
    }
}
