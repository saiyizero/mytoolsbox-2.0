package com.virugan.control;

import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.myUtlis.myJsonUtils;
import com.virugan.service.baseDeclareServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 基础词典维护
 * **/
@Controller
@RequestMapping("webGetr/baseDeclareControl/")
public class baseDeclareControl {
    @Autowired
    baseDeclareServ basedeclareserv;

    /*基础字典全量查询*/
    @RequestMapping(value="fuzzyQuery.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String fuzzyQuery(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(basedeclareserv.fuzzyQuery(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*基础字典模糊查询*/
    @RequestMapping(value="blurredQuery.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  String blurredQuery(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(basedeclareserv.blurredQuery(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    //添加基础字典
    @RequestMapping(value="addWordBook.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addWordBook(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(basedeclareserv.addWordBook(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

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
