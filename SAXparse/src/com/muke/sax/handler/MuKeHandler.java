package com.muke.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//自定义事件监听器，继承DefaultHandler来实现该接口的方法
public class MuKeHandler extends DefaultHandler {
	
	//定义一个变量来保存正在村里的tag
	private String currentTag;
	
	//每当处理文本数据时将触发该方法
	@Override	
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
//	为什么一样的操作，形参名跟视频的不一样？
		String content=new String(arg0,arg1,arg2);
		if(content.trim().length()>0) {
			System.out.println("<"+currentTag+">元素的值是："+content.trim());
		}
	}
	
	//解析文档结束时触发该方法
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	//解析元素结束时触发该方法
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("处理元素结束"+arg2);
	}

	//每当解析文档开始时触发该方法
	@Override
	public void startDocument() throws SAXException {
		System.out.println("解析文档开始：");
	}
	
	//解析元素时开始触发该方法
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		System.out.println("开始处理元素："+arg2);
		currentTag=arg2;
		if(arg3.getLength()>0) {
			System.out.println("<"+currentTag+">元素的属性如下：");
			for(int i=0;i<arg3.getLength();i++) {
				System.out.println(arg3.getQName(i)+"--->"+arg3.getValue(i));
			}
		}
	}
	
}
