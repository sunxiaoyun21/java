package com.sxy.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class Dbhelp {
	public static Connection getConnection(){
		return ConnectionManager.getConnection();
	}
	public static void update(String sql, Object...params){
		QueryRunner query=new QueryRunner(ConnectionManager.getDataSource());
		
		try {
			query.update(sql,params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		/*Connection conn=getConnection();
		
		QueryRunner query=new QueryRunner();
		System.out.println("SQL:" + sql);
		try {
			query.update(conn,sql,params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(conn);
		}*/
	}
	
	public static <T> T query(String sql, ResultSetHandler<T> handler,Object...params){
	
		QueryRunner query=new QueryRunner(ConnectionManager.getDataSource());
		
		
		try {
			T t = query.query(sql,handler,params);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		/*Connection conn=getConnection();
		QueryRunner query=new QueryRunner();
		System.out.println("SQL:" + sql);
		try {
			return query.query(conn,sql, handler,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn);
		}
		return null;*/
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
