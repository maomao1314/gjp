package com.hypx.gjp.view;

import java.util.List;
import java.util.Scanner;

import com.hypx.gjp.controller.ZhangWuController;
import com.hypx.gjp.domain.ZhangWu;

/**
 * 视图层
 * 数据传给controller
 * @author maomao
 *
 */
public class MainView {

	private static ZhangWuController controller=new ZhangWuController();

	public void run() {
		//创建Scanner输入数字
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
 
			//接收用户的菜单选择
			int option=sc.nextInt();
			switch(option) {
			case 1:
				//1.添加账务
				addZhangWu();
				break;
			case 2:
				//2.编辑财务
				editZhangWu();
				break;
			case 3:
				//3.删除账务
				delectZhangWu();
				break;
			case 4:
				//4.查询账务
				selectZhangWu();
				break;
			case 5:
				System.exit(0);	
			}		
		}
	}
	
	private void delectZhangWu() {
		System.out.println("您确定要删除？？ ");
		selectAll();
		System.out.println("序号是");
		int zwid=new Scanner(System.in).nextInt();
		controller.delectZhangWu(zwid);
		System.out.println("删除成功");
		
		
	}

	private void editZhangWu() {
		selectAll();
		System.out.println("请输入你要查询的id");
		Scanner sc=new Scanner(System.in);
		int zwid=sc.nextInt();
		System.out.println("请输入类别：");
		String flname = sc.next();
		System.out.println("请输入账户：");
		String zhanghu=sc.next();
		System.out.println("请输入金额：");
		double money = sc.nextDouble();
		System.out.println("发生日期：");
		String createtime = sc.next();
		System.out.println("备注");
		String description = sc.next();
		ZhangWu zw=new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
		controller.editZhangWu(zw);
		System.out.println("编辑成功");
		
	}

	private void addZhangWu() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("请输入类别：");
		String flname = sc.next();
		System.out.println("请输入账户：");
		String zhanghu=sc.next();
		System.out.println("请输入金额：");
		double money = sc.nextDouble();
		System.out.println("发生日期：");
		String createtime = sc.next();
		System.out.println("备注");
		String description = sc.next();
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
	}

	public static void selectZhangWu() {
		System.out.println("1.查询所有    2.条件查询");
		Scanner sc=new Scanner(System.in);
		int selectchoose=sc.nextInt();
		switch(selectchoose) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		}
		
	}
	
	public static void selectAll() {
		//调用控制层
		List<ZhangWu> list = controller.selectAll();
		print(list);
		
	}
	
	public static void select() {
		//调用控制层
		System.out.println("选择条件查询，日期格式XXXX-XX-XX");
		System.out.println("请输入开始日期");
		Scanner sc=new Scanner(System.in);
		String startime = sc.nextLine();
		System.out.println("请输入结束时间");
		String endtime = sc.nextLine();
		List<ZhangWu> list = controller.select(startime, endtime);
		print(list);
		
	}

	private static void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t账户\t\t金额\t\t时间\t\t说明");
		for(ZhangWu li:list) {
			System.out.println(li.getZwid()+"\t"+li.getFlname()+""+"\t"+li.getZhanghu()+"\t\t"+li.getMoney()+"\t\t"+
		""+li.getCreatetime()+"\t"+li.getDescription());
		}
	}
}
