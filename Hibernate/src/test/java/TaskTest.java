import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Task;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/15.
 */
public class TaskTest {

    @Test
    public void save(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Task task=new Task();
        task.setName("张s三");

        session.save(task);


        session.getTransaction().commit();
    }

    @Test
    public void update() throws InterruptedException {
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();



        Task task= (Task) session.get(Task.class,"402881895acfe569015acfe56cbe0000", LockMode.UPGRADE);
        task.setName("ooooo");


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Session session1=HibernateUtil.getSession();
                session1.getTransaction().begin();
                Task task2= (Task) session1.get(Task.class,"402881895acfe569015acfe56cbe0000");
                task2.setName("dcdxs");
                session1.update(task2);

                session1.getTransaction().commit();
            }
        });
        thread.start();
        Thread.sleep(2000);
        //Thread.sleep(15000 );

        session.update(task);
        session.getTransaction().commit();
    }
}
