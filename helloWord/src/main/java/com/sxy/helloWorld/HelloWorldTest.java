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

	//��һ������������
	@Test
	public void deployment(){
		Deployment deployment=   engine.getRepositoryService()//��ȡRepositoryService
				.createDeployment().addClasspathResource("diagrams/HelloWorld.bpmn")
				.addClasspathResource("diagrams/HelloWorld.png")//����������Դ�ļ�bpmn/png
				.deploy();
		
		System.out.println(deployment.getName());
		System.out.println(deployment.getId());
	}

	//��������
	@Test
	public void startProcess(){
	    ProcessInstance pi=engine.getRuntimeService().startProcessInstanceByKey("myProcess");
		System.out.println(pi.getId());
		System.out.println(pi.getName());
		System.out.println(pi.getProcessDefinitionId());
		
	}
	
	//�鿴�����б�
	@Test
	public void getTaskList(){
		
		String assignee="����";
		List<Task> taskList=engine.getTaskService().createTaskQuery()//������ѯ����
				.taskAssignee(assignee)//���ò�ѯ����
				//.processDefinitionId(processDefinitionId)
				.orderByTaskAssignee().desc().list();
		System.out.println(taskList.size());
		
		for(Task task:taskList){
			System.out.println("�����ˣ�"+task.getAssignee());
			System.out.println("name"+task.getName());
			System.out.println("���̶���id:"+task.getProcessDefinitionId());
		}
				
				
		
	}

	//����ҵ��
	@Test
	public void doTaskList(){
		String assignee="";
		
		String taskId="5004";
		engine.getTaskService().complete(taskId);
		
		System.out.println("��ɳɹ�");
		
		
		
		
		
	}

}
