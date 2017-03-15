import com.sxu.util.HibernateUtil;
import com.sxy.pojo.Students;
import com.sxy.pojo.Teacher;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/14.
 */
public class ManyToManyTest {

    @Test
    public void save(){

        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Students students=new Students();
        students.setName("s1");

        Students students1=new Students();
        students1.setName("s2");

        Teacher teacher=new Teacher();
        teacher.setTeacher("w2");

        Teacher teacher1=new Teacher();
        teacher1.setTeacher("w1");

       Set<Teacher> teachers=new HashSet<>();
       teachers.add(teacher);
       teachers.add(teacher1);

       students.setTeacherSet(teachers);
       students1.setTeacherSet(teachers);


       Set<Students> studentss=new HashSet<>();
       studentss.add(students);
       studentss.add(students1);

        session.save(students);
        session.save(students1);
        session.save(teacher);
        session.save(teacher1);


        session.getTransaction().commit();

    }

    @Test
    public void find(){
        Session session= HibernateUtil.getSession();
        session.getTransaction().begin();

        Students students= (Students) session.get(Students.class,1);
        System.out.println(students.getName());

        //1.在映射文件中奖lazy属性配置为false
        //Hibernate.initialize(students.getTeacherSet());
       // students.getTeacherSet().size();
        //OpenSessionInView Filter;


        session.getTransaction().commit();

        Set<Teacher> teachers=students.getTeacherSet();
        for(Teacher teacher:teachers){
            System.out.println(teacher.getTeacher());
        }

    }
}
