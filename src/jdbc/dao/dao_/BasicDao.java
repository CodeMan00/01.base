package jdbc.dao.dao_;

import jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author gjd
 * @create 2021/9/28  15:48:30
 *
 * 开发BasicDao是其他DAO的父类
 */
public class BasicDao<T> {//泛型指定具体的类型

    private QueryRunner queryRunner = new QueryRunner();

    //开发通用的dml 方法  针对任意的表
    public int update(String sql,Object ... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();

            int rows = queryRunner.update(connection, sql, parameters);

            return rows;
        } catch (SQLException e) {
            //将编译异常转换为运行时异常
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }


    //返回多个对象  查询的结果是多行的
    @Test
    public List<T> queryMulti(String sql,Class clazz,Object ... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();

            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }


    //查询单行结果的通用方法
    @Test
    public T querySingle(String sql,Class clazz,Object ...parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return  queryRunner.query(connection,sql,new BeanHandler<T>(clazz),parameters);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }


    //查询单行单列的通用方式
    @Test
    public Object queryScalar(String sql,Object ... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
