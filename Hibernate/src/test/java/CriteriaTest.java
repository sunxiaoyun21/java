import com.sxu.util.HibernateUtil;
import com.sxy.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class CriteriaTest {

    @Test
    public void findAll(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        Criteria criteria=session.createCriteria(User.class);
        List<User> list=criteria.list();

        for(User user:list){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }

    @Test
    public void where(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        Criteria criteria=session.createCriteria(User.class);
        //criteria.add(Restrictions.eq("password","123123"));
        //criteria.add(Restrictions.like("name","s", MatchMode.ANYWHERE));

        //criteria.add(Restrictions.or
                //(Restrictions.eq("password","123123"),Restrictions.like("name","s1",MatchMode.ANYWHERE)));

     /*   Disjunction disjunction=Restrictions.disjunction();
        disjunction.add(Restrictions.eq("password","123123"));
        disjunction.add(Restrictions.like("name","s1",MatchMode.ANYWHERE));
        criteria.add(disjunction);*/
        criteria.addOrder(Order.desc("id"));

        List<User> list=criteria.list();
        for(User user:list){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

@Test
    public void count(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        Criteria criteria=session.createCriteria(User.class);

        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));

        criteria.setProjection(projectionList);

        Object[] obj= (Object[]) criteria.uniqueResult();

        System.out.println(obj[0]);
        System.out.println(obj[1]);

        session.getTransaction().commit();
    }
}
