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
		
		//获取zip文件的输入流
		InputStream inputStream=this.getClass()
				.getClassLoader().getResourceAsStream("diagrams/HelloWorld.zip");
		
		ZipInputStream zipInputStream=new ZipInputStream(inputStream);
		
		Deployment deployment=engine.getRepositoryService().createDeployment().name("zipDeploy")
		                 .addZipInputStream(zipInputStream).deploy();
		
		System.out.println("流程ID"+deployment.getId());
		System.out.println("流程name:"+deployment.getName());
		
		
	}
	
	
	//获取流程定义
	@Test
	public void getProcessDef(){
		List<ProcessDefinition> definitionList = engine.getRepositoryService().createProcessDefinitionQuery()//创建查询query对象
		.processDefinitionKey("myProcess").list();//封装查询条件
		
		
		for(ProcessDefinition definition:definitionList){
			System.out.println(definition.getId());
			System.out.println(definition.getVersion());
			System.out.println(definition.getName());
			
		}
		
		System.out.println(definitionList.size());
		
	}
	
	//删除流程定义
	@Test
	public void delProcessDef(){
		//不带级联删除，只能删除没有启动的流程
		//engine.getRepositoryService().deleteDeployment("2501");
		//级联删除，不管流程是否启动，都能删除
		engine.getRepositoryService().deleteDeployment("12501",true);
		
		System.out.println("删除成功");
	}
	
	//获取流程定义PNG
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
