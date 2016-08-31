package com.gl.club.common.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AccessTokenUtil {
	//单例模式 懒汉式
	private static AccessTokenUtil accessTokenUtil;
	
	private AccessTokenUtil(){
		
	}

	public static AccessTokenUtil getInstance(){
		if(accessTokenUtil == null){
			accessTokenUtil = new AccessTokenUtil();
		}
		return accessTokenUtil;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getAccessToken(String appId,String secret){
		Map<String, String> resMap = new HashMap<String, String>();
		String mainAccessToken = null;
		String jsAccessToken = null;
		String filepath = AccessToken.class.getClassLoader().getResource("com/gl/club/common/tools/accessToken2.xml").getPath();
		System.out.println("filepath======"+filepath);
		//读取文件
		try {
			Map<String, String> readMap = new HashMap<String, String>();
			Document document = new SAXReader().read(filepath);
			//读取根节点
			Element root = document.getRootElement();//Tokens
			List<Element> nodeList = root.elements();//WxAccount
			//System.out.println(nodeList.get(2).attributeValue("appId"));
			for(int i=0;i<nodeList.size();i++){
				Element accoutEle = nodeList.get(i);
				if(appId.equals(accoutEle.attributeValue("appId"))){
					List<Element> eleList = accoutEle.elements();
					for(Element e :eleList){
						readMap.put(e.getName(),e.getText());
					}
				}
			}
			//如果没有则创建
			if(EmptyUtil.isNullOrEmpty(readMap)){
				readMap = createNode(appId,secret,filepath);
			}
			//主token
			mainAccessToken = readMap.get("MainAccessToken");
			//主token过期时间
			String mainPassTime =  readMap.get("MainAccessTokenTime");
			//js Token
			jsAccessToken = readMap.get("JSAccessToken");
			//js Token过期时间
			String jsPassTime = readMap.get("JSAccessTokenTime");
			
			resMap.put("isUpdate", "0");
			resMap.put("mainToken", mainAccessToken);
			resMap.put("jsToken", jsAccessToken);
			
			Date now = new Date();
			Date mainAccessExpires = DateUtil.formatDateStr(mainPassTime, DateUtil.ISO_EXPANDED_DATETIME_FORMAT);
			Date jsAccessExpires = DateUtil.formatDateStr(jsPassTime, DateUtil.ISO_EXPANDED_DATETIME_FORMAT);
			
			if(now.getTime() > jsAccessExpires.getTime()){
				XMLWriter writer = new XMLWriter(new FileWriter(new File(filepath)));
				if(now.getTime() > mainAccessExpires.getTime()){
					mainAccessToken = updateAccessToken(root, appId, secret);
				}
				jsAccessToken = updateJSAccessToken(root, appId, mainAccessToken);
				resMap.put("isUpdate", "1");
				resMap.put("mainToken", mainAccessToken);
				resMap.put("jsToken", jsAccessToken);
				writer.write(document);
				writer.close();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	public static void main(String[] args) {
		//AccessTokenUtil.getInstance().getAccessToken("wx29b037d609b57e68", "b049cb0f5ea75d1c78fcf10c0e23950e");
		//AccessTokenUtil.getInstance().getAccessToken("wxa15d62e69761e83a", "fcb448afd08e9f3c228fd83eadf6985e");
		AccessTokenUtil.getInstance().getAccessToken("wxe5380dfa90c1a550", "124fed190b77c527586a6ac2f54c08d2");
	}
	
	private Map<String, String> createNode(String appId,String secret,String filePath){
		Map<String, String> readMap = new HashMap<String, String>();
	     try {
		     //创建节点
		     Element accountEltm = DocumentHelper.createElement("WxAccount"); 
		     Element mainTokenElem = DocumentHelper.createElement("MainAccessToken"); 
		     Element mainTokenTimeElem = DocumentHelper.createElement("MainAccessTokenTime"); 
		     Element jsTokenElm = DocumentHelper.createElement("JSAccessToken");
		     Element jsTokenTimeElm = DocumentHelper.createElement("JSAccessTokenTime");
		     
		     //节点赋值
		     Date now = new Date();
		     Date passTime = new Date(now.getTime() + 6500000);
		     String mainAccessToken = WxUtils.getAccesstoken(appId, secret);
		     mainTokenElem.setText(mainAccessToken);
		     String jsAccessToken = WxUtils.getJSAccesstoken(mainAccessToken);
		     jsTokenElm.setText(jsAccessToken);
		     String passTimeStr = DateUtil.formatDateTime(passTime);
		     mainTokenTimeElem.setText(passTimeStr);
		     jsTokenTimeElm.setText(passTimeStr);
		     Document doc = new SAXReader().read(filePath);
			 // 根节点  
	         Element root = doc.getRootElement(); 
	         //添加节点
	         accountEltm.add(mainTokenElem);
	         accountEltm.add(mainTokenTimeElem);
	         accountEltm.add(jsTokenElm);
	         accountEltm.add(jsTokenTimeElm);
	         accountEltm.addAttribute("appId", appId);
	         root.add(accountEltm);
	         //写入XML
	         XMLWriter writer = new XMLWriter(new FileWriter(new File(filePath)));
	         writer.write(doc);
			 writer.close();
			 //返回值
			 readMap.put("MainAccessToken", mainAccessToken);
			 readMap.put("MainAccessTokenTime", passTimeStr);
			 readMap.put("JSAccessToken", jsAccessToken);
			 readMap.put("JSAccessTokenTime", passTimeStr);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     return readMap;
	}
	
	
	@SuppressWarnings("unchecked")
	public String updateAccessToken(Element root,String appId,String secret) {  
		 String accessToken = null;
         List<Element> nodes = root.elements();  
         for(Element e :nodes){
        	 if(appId.equals(e.attributeValue("appId"))){
        		 Date now = new Date();
        		 String passTime = DateUtil.formatDateTime(new Date(now.getTime() + 6500000));
        		 accessToken = WxUtils.getAccesstoken(appId, secret);
        		 e.element("MainAccessToken").setText(accessToken);
        		 e.element("MainAccessTokenTime").setText(passTime);
        	 }
         }
		 return accessToken;
    }  
	
	@SuppressWarnings("unchecked")
	public String updateJSAccessToken(Element root,String appId,String accessToken){
		 String jsAccessToken = null;
	      // 取得某节点下名为"menu"的所有字节点  
         List<Element> nodes = root.elements();  
         for(Element e :nodes){
        	 if(appId.equals(e.attributeValue("appId"))){
        		 Date now = new Date();
        		 String passTime = DateUtil.formatDateTime(new Date(now.getTime() + 6500000));
        		 jsAccessToken = WxUtils.getJSAccesstoken(accessToken);
        		 e.element("JSAccessToken").setText(jsAccessToken);
        		 e.element("JSAccessTokenTime").setText(passTime);
        	 }
         }
		return jsAccessToken;
	}
}
