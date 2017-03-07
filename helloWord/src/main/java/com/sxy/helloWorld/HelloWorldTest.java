package com.sxy.helloWorld;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorldTest {
	
	ProcessEngine engine=ProcessEngines.getDefaultProcessEngine();

	//第一步，部署流程
	@Test
	public void deployment(){
		Deployment deployment=   engine.getRepositoryService()//获取RepositoryService
				.createDeployment().addClasspathResource("diagrams/HelloWorld.bpmn")
				.addClasspathResource("diagrams/HelloWorld.png")//部署流程资源文件bpmn/png
				.deploy();
		
		System.out.println(deployment.getName());
		System.out.println(deployment.getId());
	}

	//启动流程
	@Test
	public void startProcess(){
	    ProcessInstance pi=engine.getRuntimeService().startProcessInstanceByKey("myProcess");
		System.out.println(pi.getId());
		System.out.println(pi.getName());
		System.out.println(pi.getProcessDefinitionId());
		
	}
	
	//查看任务列表
	@Test
	public void getTaskList(){
		
		String assignee="张三";
		List<Task> taskList=engine.getTaskService().createTaskQuery()//创建查询对象
				.taskAssignee(assignee)//设置查询条件
				//.processDefinitionId(processDefinitionId)
				.orderByTaskAssignee().desc().list();
		System.out.println(taskList.size());
		
		for(Task task:taskList){
			System.out.println("办理人："+task.getAssignee());
			System.out.println("name"+task.getName());
			System.out.println("流程定义id:"+task.getProcessDefinitionId());
		}
				
				
		
	}

	//办理业务
	@Test
	public void doTaskList(){
		String assignee="";
		
		String taskId="5004";
		engine.getTaskService().complete(taskId);
		
		System.out.println("完成成功");
		
		
		
		
		
	}

}
