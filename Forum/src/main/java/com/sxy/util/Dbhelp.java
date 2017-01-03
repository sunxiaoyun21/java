package com.sxy.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

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
	public static Integer insert(String sql,Object... params)  {
		try {
			QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

			return queryRunner.insert(sql,new ScalarHandler<Long>(),params).intValue();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public static <T> T query(String sql, ResultSetHandler<T> handler,Object...params){
	
		QueryRunner query=new QueryRunner(ConnectionManager.getDataSource());
		
		
		try {
			T t = query.query(sql,handler,params);
			System.out.println("SQL:" + sql);
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
