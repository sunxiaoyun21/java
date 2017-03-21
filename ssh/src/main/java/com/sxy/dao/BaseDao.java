package com.sxy.dao;

import com.sxy.pojo.User;
import com.sxy.util.Page;
import com.sxy.util.QueryParam;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class BaseDao<T,PK extends Serializable> {

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

    public T findById(PK id){
       return (T) getSession().get(clazz,id);
    }

    public List<T> findAll(){
        Criteria criteria=getSession().createCriteria(clazz);
        return criteria.list();
    }

    public Long cont(){
        Criteria criteria=getSession().createCriteria(clazz);
       criteria.setProjection(Projections.rowCount());
       return (Long) criteria.uniqueResult();
    }




    public Page<T> findbyPage(int pageNo,int pageSize){
        Page<T> page=new Page<T>(pageNo,pageSize,cont().intValue());
        Criteria criteria=getSession().createCriteria(clazz);
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(pageSize);
        List<T> items=criteria.list();
        page.setItems(items);
        return page;

    }

    public Long cont(List<QueryParam> queryParamList){
        Criteria criteria=getSession().createCriteria(clazz);
        for (QueryParam queryParam:queryParamList){
            criteria.add(buildCriteriaByQueryParam(queryParam));
        }
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public Page<T> findbyPage(int pageNo,int pageSize,List<QueryParam> queryParamList) {
        Long count=cont(queryParamList);
        Page<T> page=new Page<T>(pageNo,pageSize,count.intValue());
        Criteria criteria=getSession().createCriteria(clazz);
        for (QueryParam queryParam:queryParamList){
            criteria.add(buildCriteriaByQueryParam(queryParam));
        }
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(pageSize);
        List<T> items=criteria.list();
        page.setItems(items);
        return page;


    }

    public List<T> findByQueryParam(List<QueryParam> queryParamList){
        Criteria criteria=getSession().createCriteria(clazz);
        for (QueryParam queryParam:queryParamList){
            criteria.add(buildCriteriaByQueryParam(queryParam));
        }
        return criteria.list();
    }


   private Criterion buildCriteriaByQueryParam(QueryParam queryParam){
        String propertyName=queryParam.getPropertyName();
       Object value=queryParam.getValue();
       String type=queryParam.getType();
        if(propertyName.contains("_or_")){
            String[] array=propertyName.split("_or_");
            Disjunction disjunction=Restrictions.disjunction();
            for (String name:array){
               Criterion criterion=buildCriteriaByQueryParam(name,value,type);
               disjunction.add(criterion);
            }
            return disjunction;
        }else {
            return buildCriteriaByQueryParam(propertyName,value,type);
        }



   }

    private Criterion buildCriteriaByQueryParam(String propertyName,Object value,String type){

        if("eq".equalsIgnoreCase(type)){
            return Restrictions.eq(propertyName,value);
        }else if("gt".equalsIgnoreCase(type)){
            return Restrictions.gt(propertyName,value);
        }else if("ge".equalsIgnoreCase(type)) {
            return Restrictions.ge(propertyName, value);
        }else if("lt".equalsIgnoreCase(type)) {
            return Restrictions.lt(propertyName, value);
        }else if("le".equalsIgnoreCase(type)) {
            return Restrictions.le(propertyName, value);
        }else if("like".equalsIgnoreCase(type)) {
            return Restrictions.like(propertyName, value.toString(), MatchMode.ANYWHERE);
        }
        return null;
    }
}
