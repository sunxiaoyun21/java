import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Card;
import com.sxy.pojo.User;
import org.hibernate.Cache;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class HibernateTest {
    @Test
    public void save(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        User user=new User();
        user.setName("李四");
        user.setPassword("123123");
        session.save(user);
        session.getTransaction().commit();
    }

    @Test
    public void findById(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        User user= (User) session.get(User.class,20);
        System.out.println(user);

        //清除所有对象一级缓存缓存session.clear();
        //session.evict(user);//清除指定缓存

        session.getTransaction().commit();

        Cache cache=HibernateUtil.getSessionFactory().getCache();

        //清除所有的二级缓存
        cache.evictAllRegions();
        //清除指定对象的二级缓存
        //cache.evictEntityRegion(User.class);
        Session session1=HibernateUtil.getSession();
        session1.getTransaction().begin();

        User user1= (User) session1.get(User.class,20);
        System.out.println(user1);

        session1.getTransaction().commit();

    }

    @Test
    public void update(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        User user= (User) session.get(User.class,14);
        user.setName("张翰");
        session.getTransaction().commit();
    }

    @Test
    public void findAll(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        String hql="from User where id=?";
        Query query=session.createQuery(hql);
        query.setParameter(0,11);
        List<User> users=query.list();
        for (User user:users){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }

    @Test
    public void delete(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        User user= (User) session.get(User.class,14);
        session.delete(user);

        session.getTransaction().commit();
    }
}
