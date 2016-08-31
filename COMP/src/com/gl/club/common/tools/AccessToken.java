package com.gl.club.common.tools;

import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/****
 * 
 * <b>类名：</b>AccessToken.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>获取AccessToken(包括主token jstoken 网页授权token)</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-14 下午2:37:50
 */
public class AccessToken {

		// 定义一个私有的静态全局变量来保存该类的唯一实例
		private static AccessToken accessToken;

		// / 这样在外部便无法使用 new 来创建该类的实例
		private AccessToken() {

		}
		// / 定义一个全局访问点
		public static AccessToken getInstance() {
			// 这里可以保证只实例化一次
			// 即在第一次调用时实例化
			// 以后调用便不会再实例化
			if (accessToken == null) {
				accessToken = new AccessToken();
			}
			return accessToken;
		}
		
		
		@SuppressWarnings("unchecked")
		public Map<String, String> getAccesstoken(String appId,String secret){
			
			Map<String, String> resMap = new HashMap<String, String>();
			String mainAccessToken = null;
			
			//获取AccessToken XML路径
			String filepath = AccessToken.class.getClassLoader().getResource("com/gl/club/common/tools/accessToken.xml").getPath();
			System.out.println("filepath======"+filepath);
			
			try {
				// 读取XML文件中的数据
				Document document = new SAXReader().read(filepath);
				//定义解析结果
				Map<String,String> readMap = new HashMap<String, String>();
				//获取XML根节点
				Element root = document.getRootElement();
				//子节点集合
				List<Element> elementsList = root.elements();
				//遍历子节点
				for(Element e : elementsList){
					readMap.put(e.getName(), e.getText());
				}
				
				mainAccessToken = readMap.get("MainAccessToken");
				String passTime =  readMap.get("MainAccessTokenTime");
				
				Date now = new Date();
				Date accessExpires = DateUtil.formatDateStr(passTime, DateUtil.ISO_EXPANDED_DATETIME_FORMAT);
				
				resMap.put("isUpdate", "0");
				resMap.put("mainToken", mainAccessToken);
				//比较时间 判断token是否已经过期
				if(now.getTime()> accessExpires.getTime()){
					mainAccessToken = WxUtils.getAccesstoken(appId, secret);
					accessExpires = new Date(now.getTime() + 6500000);
					resMap.put("isUpdate", "1");
					resMap.put("mainToken", mainAccessToken);
					String nextTime = DateUtil.formatDateTime(accessExpires);
					
					root.selectSingleNode("MainAccessToken").setText(mainAccessToken);
					root.selectSingleNode("MainAccessTokenTime").setText(nextTime);
					
					XMLWriter writer = new XMLWriter(new FileWriter(new File(filepath)));
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
		
		@SuppressWarnings("unchecked")
		public Map<String, String> getJSAccessToken(String appId,String secret){
			Map<String, String> resMap = new HashMap<String, String>();
			//主token
			String mainAccessToken = null;
			String jsAccessToken = null;
			String filepath = AccessToken.class.getClassLoader().getResource("com/gl/club/common/tools/accessToken.xml").getPath();
			System.out.println("filepath======"+filepath);
			
			
			try {
				//读取文件
				Document document = new SAXReader().read(filepath);
				
				// 将解析结果存储在HashMap中
				Map<String, String> readMap = new HashMap<String, String>();
				
				//读取根节点
				Element root = document.getRootElement();
				
				//获取子节点结合
				List<Element> elements = root.elements();
				
				for(Element e : elements){
					readMap.put(e.getName(), e.getText());
				}
				//主token
				mainAccessToken = readMap.get("MainAccessToken");
				//主token过期时间
				String mainPassTime =  readMap.get("MainAccessTokenTime");
				
				jsAccessToken = readMap.get("JSAccessToken");
				String jsPassTime = readMap.get("JSAccessTokenTime");
				
				Date now = new Date();
				Date mainAccessExpires = DateUtil.formatDateStr(mainPassTime, DateUtil.ISO_EXPANDED_DATETIME_FORMAT);
				Date jsAccessExpires = DateUtil.formatDateStr(jsPassTime, DateUtil.ISO_EXPANDED_DATETIME_FORMAT);
				
				resMap.put("isUpdate", "0");
				resMap.put("mainToken", mainAccessToken);
				resMap.put("jsToken", jsAccessToken);
				if(now.getTime() > jsAccessExpires.getTime()){
					XMLWriter writer = new XMLWriter(new FileWriter(new File(filepath)));
					if(now.getTime() > mainAccessExpires.getTime()){
						mainAccessToken = WxUtils.getAccesstoken(appId, secret);
						mainAccessExpires = new Date(now.getTime() + 6500000);
						String nextMainTokenPassTime = DateUtil.formatDateTime(mainAccessExpires);
						root.selectSingleNode("MainAccessToken").setText(mainAccessToken);
						root.selectSingleNode("MainAccessTokenTime").setText(nextMainTokenPassTime);
					}
					jsAccessToken = WxUtils.getJSAccesstoken(mainAccessToken);
					jsAccessExpires = new Date(now.getTime() + 6500000);
					String nextJsTokenPassTime  = DateUtil.formatDateTime(jsAccessExpires);
					root.selectSingleNode("JSAccessToken").setText(jsAccessToken);
					root.selectSingleNode("JSAccessTokenTime").setText(nextJsTokenPassTime);
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
	
}
