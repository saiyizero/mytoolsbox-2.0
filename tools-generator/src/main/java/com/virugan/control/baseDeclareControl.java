package com.virugan.control;

import com.virugan.myUtlis.myJsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 基础词典维护
 * **/
@RestController
@RequestMapping("/getr/baseDeclareControl/")
public class baseDeclareControl {

    //基础字典模糊查询
    @RequestMapping(value="fuzzyQuery.req")
    public String fuzzyQuery(Map<String,Object> ctxmap){
        return myJsonUtils.toJsonString(ctxmap);
    }

    //添加基础字典
    @RequestMapping(value="addWordBook.req")
    public String addWordBook(Map<String,Object> ctxmap){
        return myJsonUtils.toJsonString(ctxmap);
    }

    //修改基础字典
    @RequestMapping(value="updWordBook.req")
    public String updWordBook(Map<String,Object> ctxmap){
        return myJsonUtils.toJsonString(ctxmap);
    }

    //删除基础字典
    @RequestMapping(value="delWordBook.req")
    public String delWordBook(Map<String,Object> ctxmap){
        return myJsonUtils.toJsonString(ctxmap);
    }
}
