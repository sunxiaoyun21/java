import com.sxu.util.HibernateUtil;
import com.sxy.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class HQLTest {

    @Test
    public void findAll(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        String Hql="from User where name=?";
        Query query=session.createQuery(Hql);
        query.setParameter(0,"s1");
        List<User> users=query.list();
           for (User user:users){
               System.out.println(user);
           }

        session.getTransaction().commit();
    }

    @Test
    public void queryProperty(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        String hql="select id,name,password from User";
        Query query=session.createQuery(hql);
        List<Object[]> list=query.list();

        for (Object[] obj:list){
            System.out.println(obj[0]+"->"+obj[1]+"->"+obj[2]);
        }

        session.getTransaction().commit();
    }

    @Test
    public void count(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        String hql="select count(*),max(id) from User";
        Query query=session.createQuery(hql);
       // Long  count= (Long) query.uniqueResult();
       List list=query.list();
        for (Object obj:list){
            Object[] result= (Object[]) obj;
            System.out.println(result[0]);
            System.out.println(result[1]);
        }

        session.getTransaction().commit();
    }


    @Test
    public void limit(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        String hql="from User";
        Query query=session.createQuery(hql);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<User> list=query.list();
        for (User user:list){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }
}
