package com.sxy.service;

import com.sxy.pojo.Leave;
import com.sxy.pojo.User;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */

public interface LeaveWorkFlow {


    void processStart(Leave leave,User user, String processDefKey, Map<String, Object> variables);

}
