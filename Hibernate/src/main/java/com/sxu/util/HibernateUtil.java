package com.sxu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Administrator on 2017/3/13.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory=builderSessionFactory();
    //1.创建SessionFactory
    private static SessionFactory builderSessionFactory() {
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);

    }
    public static SessionFactory getSessionFactory(){
        return  sessionFactory;
    }
    //2.创建Session
    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }
}
