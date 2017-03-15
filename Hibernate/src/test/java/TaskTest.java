import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Task;
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
        task.setName("张三");

        session.save(task);


        session.getTransaction().commit();
    }
}
