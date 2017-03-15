import com.sxu.util.HibernateUtil;
import com.sxy.pojo.School;
import com.sxy.pojo.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/14.
 */
public class OneToManyTest {

    @Test
    public  void save(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        School school=new School();
        school.setSchoolname("实验小学");
        session.save(school);

        Student student=new Student();
        student.setName("李四");
        session.save(student);
        student.setSchool(school);

        Student student1=new Student();
        student1.setName("王五");
        student1.setSchool(school);
        session.save(student1);

        session.getTransaction().commit();
    }

    @Test
    public void oneToMany(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        School school= (School) session.get(School.class,4);
        System.out.println(school.getSchoolname());

        Set<Student> students=school.getStudentSet();
        for (Student student:students){
            System.out.println(student.getName());
        }

        /*Student student= (Student) session.get(Student.class,3);
        System.out.println(student.getName());*/

        session.getTransaction().commit();
    }

    @Test
    public void manyToOne(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();
        //n+1
        Criteria criteria=session.createCriteria(Student.class);
        List<Student> list=criteria.list();

        for (Student student:list){
            System.out.println(student.getName()+"->"+student.getSchool().getSchoolname());
        }


       /* Student student= (Student) session.get(Student.class,3);
        System.out.println(student.getName());
        //懒加载
        System.out.println(student.getSchool().getSchoolname());*/

        session.getTransaction().commit();
    }

    @Test
    public void delete(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        School school= (School) session.get(School.class,3);
        session.delete(school);

        session.getTransaction().commit();

    }
}
