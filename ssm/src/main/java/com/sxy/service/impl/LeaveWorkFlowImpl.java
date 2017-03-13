package com.sxy.service.impl;

import com.sxy.mapper.LeaveMapper;
import com.sxy.pojo.Leave;
import com.sxy.pojo.User;
import com.sxy.service.LeaveWorkFlow;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Service
public class LeaveWorkFlowImpl implements LeaveWorkFlow {

    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    IdentityService identityService;
    @Autowired
    RuntimeService runtimeService;


    @Override
    @Transactional
    public void processStart(Leave leave,User user, String processDefKey, Map<String, Object> variables) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //封装leave请假对象并入库
        leave.setUserId(user.getId().toString());
        leave.setApplyTime(dateFormat.format(new Date()));
        leaveMapper.save(leave);
        //引擎会自动把用户ID保存到初始化变量中
        identityService.setAuthenticatedUserId(user.getId().toString());

        //启动流程
      ProcessInstance processInstance= runtimeService.startProcessInstanceByKey(processDefKey,leave.getId().toString(),variables);
        leave.setProcessInstanceId(processInstance.getProcessInstanceId());
      leaveMapper.update(leave);
    }
}
