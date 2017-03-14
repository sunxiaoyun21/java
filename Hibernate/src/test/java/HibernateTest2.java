import com.sxu.util.HibernateUtil;
import com.sxy.pojo.User;
import org.hibernate.Session;
import org.junit.Test;

public class HibernateTest2 {

    @Test
    public void getAndLoad(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        User user=new User();
        user.setName("s1");
        user.setPassword("123123");
        session.save(user);
      //User user1= (User) session.get(User.class,15);
        User user1= (User) session.load(User.class,15);

        session.getTransaction().commit();

    }

    @Test
    public void saveAndPersist(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        User user=new User();
        user.setName("s2");
        user.setPassword("123123");
        //session.save(user);
        session.persist(user);

        System.out.println(user.getId());


        session.getTransaction().commit();
    }


    @Test
    public void saveAndUpdate(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();

        User user=new User();
        user.setName("s1");
        user.setPassword("123123");

        session.save(user);
        session.getTransaction().commit();

        Session session1=HibernateUtil.getSession();
        session1.getTransaction().begin();

        user.setName("ss");
        session1.update(user);
        session1.getTransaction().commit();
    }

    @Test
    public void saveOrUpdate(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();

        User user=new User();
        user.setName("s1");
        user.setPassword("123123");

        session.saveOrUpdate(user);
        session.getTransaction().commit();

        Session session1=HibernateUtil.getSession();
        session1.getTransaction().begin();

        user.setName("ss");
        session1.saveOrUpdate(user);
        session1.getTransaction().commit();
    }

    @Test
    public void merge(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();

        User user= (User) session.get(User.class,24);
        user.setName("zjam");
        session.merge(user);

        session.getTransaction().commit();
    }
    @Test
    public void clearAndFlush(){
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();

        User user= (User) session.get(User.class,17);
        user.setName("wsx");
        session.update(user);
        //session.clear();
        session.flush();

        session.getTransaction().commit();
    }
}
