package com.muke.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//�Զ����¼����������̳�DefaultHandler��ʵ�ָýӿڵķ���
public class MuKeHandler extends DefaultHandler {
	
	//����һ���������������ڴ����tag
	private String currentTag;
	
	//ÿ�������ı�����ʱ�������÷���
	@Override	
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
//	Ϊʲôһ���Ĳ������β�������Ƶ�Ĳ�һ����
		String content=new String(arg0,arg1,arg2);
		if(content.trim().length()>0) {
			System.out.println("<"+currentTag+">Ԫ�ص�ֵ�ǣ�"+content.trim());
		}
	}
	
	//�����ĵ�����ʱ�����÷���
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	//����Ԫ�ؽ���ʱ�����÷���
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("����Ԫ�ؽ���"+arg2);
	}

	//ÿ�������ĵ���ʼʱ�����÷���
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�����ĵ���ʼ��");
	}
	
	//����Ԫ��ʱ��ʼ�����÷���
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		System.out.println("��ʼ����Ԫ�أ�"+arg2);
		currentTag=arg2;
		if(arg3.getLength()>0) {
			System.out.println("<"+currentTag+">Ԫ�ص��������£�");
			for(int i=0;i<arg3.getLength();i++) {
				System.out.println(arg3.getQName(i)+"--->"+arg3.getValue(i));
			}
		}
	}
	
}
