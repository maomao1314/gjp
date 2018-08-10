package com.hypx.gjp.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCutils {

	public static BasicDataSource dataSource=new BasicDataSource();
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setMaxActive(10);
		dataSource.setInitialSize(10);
		dataSource.setMinIdle(4);
		dataSource.setMaxIdle(5);
	} 
	public static DataSource getDataSource() {
		return  dataSource;
	}
	
}
