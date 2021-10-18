package jdbc.dao.test;


import jdbc.dao.dao_.ActorDao;
import jdbc.dao.domain.Actor;
import org.junit.Test;
import java.util.List;

/**
 * @author gjd
 * @create 2021/9/28  16:13:15
 *
 * 测试ActorDao  对actor进行crud操作
 */
public class TestDao {

    @Test
    public void testActorDao(){

        ActorDao dao = new ActorDao();

        //1.查询
        List<Actor> actors = dao.queryMulti("select * from actor where id > ?", Actor.class,1);
        for(Actor actor:actors){
            System.out.println(actor);
        }


        //查询单行结果
        Actor actor = dao.querySingle("select * from actor where id =?", Actor.class, 2);
        System.out.println(actor);



        //查询单行单列
        Object o = dao.queryScalar("select name from actor where id = ?", 2);
        System.out.println(o);
    }
}
