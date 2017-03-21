package com.sxy.dao;

import com.sxy.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/21.
 */
@Repository
public class UserDao extends BaseDao<User,Integer> {
}
