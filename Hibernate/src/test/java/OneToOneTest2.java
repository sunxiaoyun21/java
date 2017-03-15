import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Content;
import com.sxy.pojo.Topic;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/14.
 */
public class OneToOneTest2 {

    @Test
    public void save(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Topic topic=new Topic();
        topic.setTitle("标题党");

        Content content=new Content();
        content.setContent("xxxxxxxxxxxxxxx");

        topic.setContent(content);
        content.setTopic(topic);


        session.save(content);
        session.save(topic);
        session.getTransaction().commit();
    }

    @Test
    public void find(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Topic topic= (Topic) session.get(Topic.class,1);
        System.out.println(topic.getTitle());
        System.out.println(topic.getContent().getContent());


        session.getTransaction().commit();
    }
}
