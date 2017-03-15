import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Card;
import com.sxy.pojo.Person;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/14.
 */
public class OneToOneTest {

    @Test
    public void save(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Person person=new Person();
        person.setName("张三");

        Card card=new Card();
        card.setNum(1234321);
        card.setPerson(person);

        session.save(person);
        session.save(card);

        session.getTransaction().commit();

    }

    @Test
    public void find(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Card card= (Card) session.get(Card.class,3);
        System.out.println(card.getNum());

        session.getTransaction().commit();
    }

    @Test
    public void del(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Person person= (Person) session.get(Person.class,3);
        session.delete(person);

        session.getTransaction().commit();
    }
}
