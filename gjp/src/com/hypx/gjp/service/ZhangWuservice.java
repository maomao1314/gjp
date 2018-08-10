package com.hypx.gjp.service;

import java.util.List;

import com.hypx.gjp.dao.ZhangWudao;
import com.hypx.gjp.domain.ZhangWu;
/**
 * 事务层  接受上一层来的控制层来的数据
 *
 *
 */
public class ZhangWuservice {

	private ZhangWudao dao=new ZhangWudao();
	//调用ZhangWudao数据
    public List<ZhangWu> selectAll() {
		return dao.selectAll();
		
	}
	public List<ZhangWu> select(String starttime, String endtime) {
		
		return dao.select(starttime, endtime);
	}
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	public void delectZhangWu(int zwid) {
		dao.delectZhangWu(zwid);
		
	}
}
