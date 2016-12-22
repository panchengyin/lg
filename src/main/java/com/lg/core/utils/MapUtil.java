package com.lg.core.utils;

import java.util.HashMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class MapUtil {
	 /**
     * 将json格式的字符串解析成Map对象 <li>
     */
	public static HashMap<String, String> aoDataToMap(String aoData)
    {
        HashMap<String, String> data = new HashMap<String, String>();
        
        JSONArray jsonArr = JSONArray.parseArray(aoData);
        for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject obj = (JSONObject) jsonArr.get(i);
			 String key = String.valueOf(obj.get("name"));
	         String value = String.valueOf(obj.get("value"));
	         data.put(key, value);
        }
        return data;
    }
 
}
