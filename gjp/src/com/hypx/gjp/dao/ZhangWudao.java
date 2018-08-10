package com.hypx.gjp.dao;
/**
 * 实现对数据库增删改查
 * @author maomao
 *
 */

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hypx.gjp.tools.JDBCutils;
import com.hypx.gjp.domain.*;



public class ZhangWudao {
	private QueryRunner qr=new QueryRunner(JDBCutils.getDataSource());
	
	public List<ZhangWu> select(String starttime,String endtime){
		  
		 try {
			 String sql="SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN  ? AND ?";
			Object[] params= {starttime,endtime};
			 List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
		       return list;
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		 
		
	}
	
	
	public List<ZhangWu> selectAll(){
		try {
			String sql="select * from gjp_zhangwu";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}


	public void addZhangWu(ZhangWu zw) {
		try {
			String sql="INSERT INTO gjp_zhangwu(flname,money,zhanghu,createtime,description) VALUE(?,?,?,?,?); ";
			Object[] params= {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			int row = qr.update(sql,params);
			if(row>0) {
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	public void editZhangWu(ZhangWu zw) {
		try {
			String sql="UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?;";
			Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql,params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


	public void delectZhangWu(int zwid) {
		String sql="delete from gjp_zhangwu where zwid=?";
		try {
			qr.update(sql,zwid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
