package com.sxy.mapper;

import com.sxy.pojo.Leave;

/**
 * Created by Administrator on 2017/3/11.
 */
public interface  LeaveMapper {

    void save(Leave leave);
    void  delete(long id);
    Leave getLeaveById(long id);
    void update(Leave leave);
}
