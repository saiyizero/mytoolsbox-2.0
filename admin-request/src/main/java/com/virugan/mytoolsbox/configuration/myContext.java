package com.virugan.mytoolsbox.configuration;

import com.virugan.mytoolsbox.utils.myJsonUtils;

import java.util.HashMap;
import java.util.Map;

public class myContext extends HashMap<String,Object> {

    public static String FILEPATH ="filePath";
    public static String RESULT ="result";
    public static String MYLIST ="myList";

    public static String SUFFIX ="suffix";
    public static String NAME ="name";

    public static myContext getInstance(){
        return new myContext();
    }

    public String toJson(){
        return myJsonUtils.fromObjToJson(this);
    }
}
