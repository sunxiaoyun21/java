package com.sxy.dao;

import com.sxy.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class clazz;

    public BaseDao(){
        ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
       clazz = (Class) type.getActualTypeArguments()[0];
    }

    public Session getSession(){
        return (Session) sessionFactory.getCurrentSession();
    }

    public  void save(T entity){
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    public T findById(Integer id){
       return (T) getSession().get(clazz,id);
    }




    public List<T> findAll(){
        Criteria criteria=getSession().createCriteria(clazz);
        return criteria.list();
    }


}
