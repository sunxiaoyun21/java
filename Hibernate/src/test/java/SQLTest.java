import com.sxu.util.HibernateUtil;
import com.sxy.pojo.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/13.
 */
public class SQLTest {

    @Test
    public void findById(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        String sql="select * from user where id=13";
        SQLQuery sqlQuery=session.createSQLQuery(sql);
        Object[] objects= (Object[]) sqlQuery.uniqueResult();
        System.out.println(objects[0]);
        System.out.println(objects[1]);


        session.getTransaction().commit();
    }

}
