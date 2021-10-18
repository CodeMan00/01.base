package jdbc.batch;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author gjd
 * @create 2021/9/28  10:24:01
 *
 * 使用批处理处理sql语句
 *
 * 1.当需要成批插入或者更新记录时，可以采用java的批量更新机制，这一机制允许许多条语句一次性提交给数据库批量处理，通常
 *  情况下比单独提交处理更有效率。
 *  2.jdbc批处理语句包括以下方法
 *      addBatch() ：添加需要处理的sql语句或参数
 *      executeBatch() : 执行批量处理语句
 *      clearBatch() 清空批处理包的语句
 *
 *  3.jdbc连接mysql时，如果需要批处理功能，需要再url中加参数 ?rewriteBatchedStatements=true;
 *  4.批处理往往和PreparedStatement一起搭配使用，可以及减少编译次数，有减少运行次数，效率大大提高。
 *
 */
public class BatchTest {

    //使用传统方式 添加5000数据到admin2
    @Test
    public void test() throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行....");
        long l = System.currentTimeMillis();
        for(int i= 0;i<5000;i++){
            preparedStatement.setString(1,"张三"+i);
            preparedStatement.setString(2,"666");
            preparedStatement.executeUpdate();
        }
        long l1 = System.currentTimeMillis();
        System.out.println("执行时间："+(l1-l));

        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }

    //使用批量处理添加数据
    @Test
    public void test1() throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行....");
        long l = System.currentTimeMillis();

        for(int i= 0;i<5000;i++){
            preparedStatement.setString(1,"张三"+i);
            preparedStatement.setString(2,"666");
            /**
             * addBatch()源码：
             *  1.第一次添加，创建ArrayList ，底层是Object对象数组elementData
             *  2. 当elementData满后，进行1.5倍扩容
             *  3.当添加到指定的数量时，就开始批量处理，
             *  4.批量处理会减少我们发送sql语句的网络开销，而且减少编译次数（PreparedStatment会预处理），因此效率提高。
             * public void addBatch() throws SQLException {
             *         synchronized(this.checkClosed().getConnectionMutex()) {
             *             if (this.batchedArgs == null) {
             *                 this.batchedArgs = new ArrayList();
             *             }
             *
             *             for(int i = 0; i < this.parameterValues.length; ++i) {
             *                 this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
             *             }
             *
             *             this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
             *         }
             *     }
             */
            preparedStatement.addBatch();
            //当有1000条语句时 再执行
            if((i+1)%1000 ==0){
                preparedStatement.executeBatch();
                //清空 sql语句   像是一个容器似的，装下一批sql语句前，需要清空上一批sql语句
                preparedStatement.clearBatch();
            }

        }
        long l1 = System.currentTimeMillis();
        System.out.println("批量执行时间："+(l1-l));

        //关闭资源
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
