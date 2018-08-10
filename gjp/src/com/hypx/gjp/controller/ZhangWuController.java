package com.hypx.gjp.controller;
/**
 * ���Ʋ�  ������ͼ�������
 * @author maomao
 *
 */

import java.util.List;

import com.hypx.gjp.domain.ZhangWu;
import com.hypx.gjp.service.ZhangWuservice;

public class ZhangWuController {

	private ZhangWuservice service=new ZhangWuservice();
	
	public  List<ZhangWu> select(String starttime,String endtime){
		return service.select( starttime, endtime);
		
		
	}
	
	//����service����
	public List<ZhangWu> selectAll() {
		 return service.selectAll();
	}

	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}

	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}

	public void delectZhangWu(int zwid) {
		service.delectZhangWu( zwid);
	}
}
