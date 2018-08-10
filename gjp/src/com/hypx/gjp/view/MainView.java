package com.hypx.gjp.view;

import java.util.List;
import java.util.Scanner;

import com.hypx.gjp.controller.ZhangWuController;
import com.hypx.gjp.domain.ZhangWu;

/**
 * ��ͼ��
 * ���ݴ���controller
 * @author maomao
 *
 */
public class MainView {

	private static ZhangWuController controller=new ZhangWuController();

	public void run() {
		//����Scanner��������
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
 
			//�����û��Ĳ˵�ѡ��
			int option=sc.nextInt();
			switch(option) {
			case 1:
				//1.�������
				addZhangWu();
				break;
			case 2:
				//2.�༭����
				editZhangWu();
				break;
			case 3:
				//3.ɾ������
				delectZhangWu();
				break;
			case 4:
				//4.��ѯ����
				selectZhangWu();
				break;
			case 5:
				System.exit(0);	
			}		
		}
	}
	
	private void delectZhangWu() {
		System.out.println("��ȷ��Ҫɾ������ ");
		selectAll();
		System.out.println("�����");
		int zwid=new Scanner(System.in).nextInt();
		controller.delectZhangWu(zwid);
		System.out.println("ɾ���ɹ�");
		
		
	}

	private void editZhangWu() {
		selectAll();
		System.out.println("��������Ҫ��ѯ��id");
		Scanner sc=new Scanner(System.in);
		int zwid=sc.nextInt();
		System.out.println("���������");
		String flname = sc.next();
		System.out.println("�������˻���");
		String zhanghu=sc.next();
		System.out.println("�������");
		double money = sc.nextDouble();
		System.out.println("�������ڣ�");
		String createtime = sc.next();
		System.out.println("��ע");
		String description = sc.next();
		ZhangWu zw=new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
		controller.editZhangWu(zw);
		System.out.println("�༭�ɹ�");
		
	}

	private void addZhangWu() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("���������");
		String flname = sc.next();
		System.out.println("�������˻���");
		String zhanghu=sc.next();
		System.out.println("�������");
		double money = sc.nextDouble();
		System.out.println("�������ڣ�");
		String createtime = sc.next();
		System.out.println("��ע");
		String description = sc.next();
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
	}

	public static void selectZhangWu() {
		System.out.println("1.��ѯ����    2.������ѯ");
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
		//���ÿ��Ʋ�
		List<ZhangWu> list = controller.selectAll();
		print(list);
		
	}
	
	public static void select() {
		//���ÿ��Ʋ�
		System.out.println("ѡ��������ѯ�����ڸ�ʽXXXX-XX-XX");
		System.out.println("�����뿪ʼ����");
		Scanner sc=new Scanner(System.in);
		String startime = sc.nextLine();
		System.out.println("���������ʱ��");
		String endtime = sc.nextLine();
		List<ZhangWu> list = controller.select(startime, endtime);
		print(list);
		
	}

	private static void print(List<ZhangWu> list) {
		System.out.println("ID\t���\t�˻�\t\t���\t\tʱ��\t\t˵��");
		for(ZhangWu li:list) {
			System.out.println(li.getZwid()+"\t"+li.getFlname()+""+"\t"+li.getZhanghu()+"\t\t"+li.getMoney()+"\t\t"+
		""+li.getCreatetime()+"\t"+li.getDescription());
		}
	}
}
