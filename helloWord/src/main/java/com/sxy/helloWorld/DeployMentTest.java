package com.sxy.helloWorld;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class DeployMentTest {
	
	ProcessEngine engine=ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void deployZip(){
		
		//��ȡzip�ļ���������
		InputStream inputStream=this.getClass()
				.getClassLoader().getResourceAsStream("diagrams/HelloWorld.zip");
		
		ZipInputStream zipInputStream=new ZipInputStream(inputStream);
		
		Deployment deployment=engine.getRepositoryService().createDeployment().name("zipDeploy")
		                 .addZipInputStream(zipInputStream).deploy();
		
		System.out.println("����ID"+deployment.getId());
		System.out.println("����name:"+deployment.getName());
		
		
	}
	
	
	//��ȡ���̶���
	@Test
	public void getProcessDef(){
		List<ProcessDefinition> definitionList = engine.getRepositoryService().createProcessDefinitionQuery()//������ѯquery����
		.processDefinitionKey("myProcess").list();//��װ��ѯ����
		
		
		for(ProcessDefinition definition:definitionList){
			System.out.println(definition.getId());
			System.out.println(definition.getVersion());
			System.out.println(definition.getName());
			
		}
		
		System.out.println(definitionList.size());
		
	}
	
	//ɾ�����̶���
	@Test
	public void delProcessDef(){
		//��������ɾ����ֻ��ɾ��û������������
		//engine.getRepositoryService().deleteDeployment("2501");
		//����ɾ�������������Ƿ�����������ɾ��
		engine.getRepositoryService().deleteDeployment("12501",true);
		
		System.out.println("ɾ���ɹ�");
	}
	
	//��ȡ���̶���PNG
	@Test
	public void getProcessdefPng() throws IOException{
		String defId="myProcess:3:10004";
		ProcessDefinition definition = engine.getRepositoryService().createProcessDefinitionQuery()
		.processDefinitionId(defId).singleResult();
		
		String deployId=definition.getDeploymentId();
		String resource=definition.getDiagramResourceName();
		
		System.out.println("id:"+deployId);
		System.out.println("name:"+resource);
		InputStream inputStream = engine.getRepositoryService().getResourceAsStream(deployId,resource);
		
		FileUtils.copyInputStreamToFile(inputStream,new File("D:/HelloWorld.png"));
	}

}
