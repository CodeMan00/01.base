package jdbc.dbutils;

import jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author gjd
 * @create 2021/9/28  13:54:04
 *
 * dbuitls是Apache的
 *  通过dbutils 对jdbc进行封装，简化了代码
 *
 *
 *  在定义实体类和数据库中的记录进行对应时，如果数据库表中的是int字段，我们定义实体类为Integer类型
 *  也就是定义成包装类型。Date设置为java.util.Date类型
 */
public class DBUtilsTest02 {

    //使用Apache的DBUtils实现
    @Test
    public void testQueryMany() throws SQLException {

        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils 类和接口，需要dbutils.jar包
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id>=?";
//       String sql = "select id,name from actor";

        //4.query方法就是执行sql语句，得到ResultSet  封装到 ArrayList集合中
        //  (1).返回集合 （2）参数；一.连接对象 二.要执行的sql语句， 三。通过反射创建对象，封装到集合中 4.sql语句中的参数(?占位符)，可变参数
        // query方法底层会调用ResultSet、PreparedStatement对象，而且使用完毕就会关闭。
        List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<Actor>(Actor.class),1);
        for(Actor actor : query){
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }


    //返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id = ?";

        //4. 查询单行记录， 使用BeanHandler  把记录封装成单个对象   如果sql语句没有查到数据，则对象就为null
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<Actor>(Actor.class),1);
        System.out.println(actor);

        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }


    //演示 apache-dbutils + druid 完成查询结果是单行单列  返回结果是Object
    @Test
    public void testScalar() throws SQLException {

        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name  from actor where id = ?";

        Object obj = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(obj);


        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }


    //演示apache-dbutils + druid 完成 dml(update、insert、delete )
    @Test
    public void testDML() throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor value(?,?,?,?,?)";
        String sql = "delete from actor where id = ?";

        /**
         * 执行dml操作:
         *      1.使用的是update()方法
         *      2.返回值是受影响的行数
         *
         *  三个参数：连接、sql语句、可变参数
         */
        int rows = queryRunner.update(connection, sql,1);
        System.out.println(rows > 0?"执行成功":"执行失败");

    }
}
