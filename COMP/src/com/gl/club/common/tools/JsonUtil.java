package com.gl.club.common.tools;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/***
 * 
 * <b>类名：</b>JsonUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>JSON工具类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-13 下午4:56:03
 */
public class JsonUtil {

	public static List<Map<String, Object>> parseJSON2List(String jsonStr){  
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while(it.hasNext()){  
            JSONObject json2 = it.next();  
            list.add(parseJSON2Map(json2.toString()));  
        }  
        return list;  
    }  
      
     
    public static Map<String, Object> parseJSON2Map(String jsonStr){
    	if(jsonStr == null || "".equals(jsonStr)) {
    		return null;
    	}
        Map<String, Object> map = new HashMap<String, Object>();  
        //最外层解析  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        for(Object k : json.keySet()){  
            Object v = json.get(k);   
            //如果内层还是数组的话，继续解析  
            if(v instanceof JSONArray){  
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
                while(it.hasNext()){  
                    JSONObject json2 = it.next();  
                    list.add(parseJSON2Map(json2.toString()));  
                }  
                map.put(k.toString(), list);  
            } else {  
                map.put(k.toString(), v);  
            }  
        }  
        return map;  
    }  
    
    public static Map<String, Object> parseJSON2Map2(String jsonString) throws JSONException {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> result = new HashMap<String, Object>();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);

        }
        return result;

    }
    
    public static List<Map<String, Object>> getListByUrl(String url){  
        try {  
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((line=reader.readLine())!=null){  
                sb.append(line);  
            }  
            return parseJSON2List(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
     
    public static Map<String, Object> getMapByUrl(String url){  
        try {  
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((line=reader.readLine())!=null){  
                sb.append(line);  
            }  
            return parseJSON2Map(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
	
}
