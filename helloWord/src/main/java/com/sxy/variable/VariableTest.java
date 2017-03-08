package com.sxy.variable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class VariableTest {
	
	ProcessEngine engine=ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 启动任务流程,设置流程变量
	 */
	@Test
	public void startProcess(){
		Map<String,Object> variable=new HashMap<>();
		variable.put("day",5);
		variable.put("startTime",new Date());
	
		ProcessInstance instance=engine.getRuntimeService().startProcessInstanceByKey("myProcess",variable);
	}
	
	
	@Test
	public void setRuntimeVariable(){
		Map<String,Object> variable=new HashMap<>();
		variable.put("day1",5);
		variable.put("startTime1",new Date());
		engine.getRuntimeService().setVariables("22501",variable);
	}
	
	@Test
	public void setTaskVariable(){
		Map<String,Object> variable=new HashMap<>();
		variable.put("day2",5);
		variable.put("startTime2",new Date());
		engine.getTaskService().setVariables("22506",variable);
	}
	
	
	@Test
	public void getTaskVariable(){
		/*Map<String,Object> variable=new HashMap<>();
		variable.put("day2",5);
		variable.put("startTime2",new Date());
		engine.getTaskService().setVariables("22506",variable);*/
		
		Integer day=(Integer) engine.getRuntimeService().getVariable("22501","day2");
		System.out.println(day);
		
		Integer day2=(Integer) engine.getTaskService().getVariable("22506","day2");
		System.out.println(day);
		
		
	}
	
	
	
	
	/**
	 * 查看任务列表
	 */
	@Test
	public void getTaskList(){
		String assignee="李四";
		Integer day=(Integer) engine.getRuntimeService().getVariable("22501","day");
		Map<String,Object> map=engine.getRuntimeService().getVariables("22501");
		List<String> list=new ArrayList<>();
		list.add("day");
	
		Map<String,Object> variable=engine.getRuntimeService().getVariables("22501",list);
		System.out.println(variable.size());
		
		System.out.println("day:"+day);
		
		List<Task> listTask=engine.getTaskService().createTaskQuery()
				.taskAssignee(assignee).orderByTaskAssignee().desc().list();
	}

}
