package com.imooc.utils;

import java.util.UUID;

//�ļ��ϴ��Ĺ�����
public class UploadUtils {
	
	/*
	 * ����Ψһ���ļ���������ļ��������⣺
	 */
	public static String getUUIDFileName(String fileName) {
		//���ļ�����ǰ�沿�ֽ��н�ȡ��xx.jpg����������.jpg
		int idx=fileName.lastIndexOf(".");
		String extention=fileName.substring(idx);
		//��������ɵ��ļ�����-ȥ��
		String uuidFileName=UUID.randomUUID().toString().replace("-","")+extention;
		return uuidFileName;
	}
	
	public static void main(String[] args) {
		//�����������������ļ���
		System.out.println(UUID.randomUUID());
	}
}