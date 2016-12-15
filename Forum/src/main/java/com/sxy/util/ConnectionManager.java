package com.sxy.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;


public class ConnectionManager {
	private static  String DRIVER;//="com.mysql.jdbc.Driver";
	private static  String URL;//="jdbc:mysql:///lib22";
	private static String USERNAME;//="root";
	private static  String PASSWORD;//="root";
	private static BasicDataSource datasource=new BasicDataSource();
	
	static{
		Properties prop=new Properties();
		
		try {
			prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
			DRIVER=prop.getProperty("jdbc.diver");
			URL=prop.getProperty("jdbc.url");
			USERNAME=prop.getProperty("jdbc.username");
			PASSWORD=prop.getProperty("jdbc.pwd");
			
		
		} catch (IOException e) {
			
			e.printStackTrace();
		};
		
		datasource.setDriverClassName(DRIVER);
		datasource.setUrl(URL);
		datasource.setPassword(PASSWORD);
		datasource.setUsername(USERNAME);
		
		datasource.setInitialSize(5);
		datasource.setMinIdle(5);
		datasource.setMaxIdle(20);
		datasource.setMaxWaitMillis(5000);
		
		
		
	}
	/*
	 * ��ȡ���ݿ����ӳ�
	 */
	
	public static DataSource getDataSource(){
		return datasource;
	}
	public static Connection getConnection(){
		Connection conn=null;
		
		
		try {
			Class.forName(DRIVER);
			conn=datasource.getConnection();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}
