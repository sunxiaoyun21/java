package com.sxy;

import com.google.common.collect.Maps;
import com.sxy.shiro.ShiroDbRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 */
//@Configuration
public class ShiroConfig {

    @Bean
    public CacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
     return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroDbRealm dbRealm(){
        return new ShiroDbRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
         defaultWebSecurityManager.setCacheManager(cacheManager());
         defaultWebSecurityManager.setRealm(dbRealm());
         return  defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/home");
        factoryBean.setUnauthorizedUrl("/403");

        Map<String,String> filter= Maps.newLinkedHashMap();
        filter.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(filter);
        return factoryBean;
    }
}
