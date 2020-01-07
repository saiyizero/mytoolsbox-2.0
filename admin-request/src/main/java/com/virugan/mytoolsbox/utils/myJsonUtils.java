/*@(#)myJsonUtils.java   2016-4-26 
 * Copy Right 2016 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.virugan.mytoolsbox.utils;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document myJsonUtils
 * <p>
 * @version 1.0.0,2016-4-26
 * @author ling
 * @since 1.0.0
 */
public class myJsonUtils {


    public static String fromObjToJson(Object obj){
        String jsonStr = new String();
        if(obj == null)
            return "";
        try{
            jsonStr = (new ObjectMapper()).writeValueAsString(obj);
        }catch(Exception e){
            System.out.println("obj to json error.");
        }
        return jsonStr;
        
    }
    
    @SuppressWarnings("rawtypes")
	public static Map fromJsonToMap(String jsonStr) throws JsonParseException, JsonMappingException, IOException {
        Map jsonMap = null;
        if(jsonStr==null||jsonStr.equals("")){
            jsonMap = new HashMap();
            return jsonMap;
        }
        try{
            jsonMap = (Map)(new ObjectMapper()).readValue(jsonStr, Map.class);
        }catch(JsonGenerationException e){
            System.out.println("json to map error.");
        }
        return jsonMap;
    }

}
