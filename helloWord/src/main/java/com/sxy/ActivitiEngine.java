package com.sxy;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class ActivitiEngine {
	//������������ַ�ʽ
	@Test
	public void initTables(){
		ProcessEngineConfiguration peg=
				ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		//����set�����޸���������jdbc
		peg.setJdbcDriver("com.mysql.jdbc.Driver");
		peg.setJdbcUrl("jdbc:mysql:///activiti_demo");
		peg.setJdbcUsername("root");
		peg.setJdbcPassword("root");
		
		peg.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		ProcessEngine engine= peg.buildProcessEngine();
		System.out.println("engine"+engine.getName());
		
		
	}
	
	//��
	@Test
	public void initTables2(){
		ProcessEngine engine=
				ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
		System.out.println("engine:"+engine);
	}
	//��
	@Test
	public void getEngine(){
		ProcessEngine engine=ProcessEngines.getDefaultProcessEngine();
		System.out.println(engine);
	}
	
	
}
