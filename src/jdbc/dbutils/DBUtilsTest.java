package jdbc.dbutils;

import jdbc.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author gjd
 * @create 2021/9/28  13:35:17
 *
 *  为什么提出DBUtils？
 *      1.在我们获取结果集后，我们需要对结果集进行操作，然而这种操作是有限制的。结果集是和connection关联的，如果我们对
 *          connnection进行关闭后，就不能在对结果集进行操作，这不利于结果集数据的复用
 *       2.结果集不利于数据管理.当我们使用完结果集后，一般都是进行关闭操作，但是如果还想使用，这样又需要重新获取
 *          这样是不方便的。我们希望对数据进行保存，这样也可以复用。
 *
 *       3.使用返回信息也不方便.因为我们从结果集中获取数据，都是通过getXxx()方法来操作的，这样我们在
 *  *          未知属性的情况下，造成了操作不方便。
 *
 *    解决办法：
 *      我们可以通过对象的方式对结果集的返回信息，进行封装，把结果集中的每条记录封装称一个实体对象，然后
 *      存入到ArrayList集合中，
 *
 *
 *
 */
public class DBUtilsTest {

    //根据上面的原理，我们自己实现对结果集数据的封装
    @Test
    public void test() throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();


        String sql = "select * from actor";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Actor> actors = new ArrayList<Actor>();
        while (resultSet.next()){

            Actor actor = new Actor();
            actor.setId(resultSet.getInt(1));
            actor.setName(resultSet.getString(2));
            actor.setSex(resultSet.getString(3));
            actor.setBorndate(resultSet.getDate(4));
            actor.setPhone(resultSet.getString(5));
            actors.add(actor);
        }

        System.out.println(actors);

        //关闭资源
        JDBCUtilsByDruid.close(null,preparedStatement,connection);
    }
}
