package com.virugan.control;

import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.myUtlis.myJsonUtils;
import com.virugan.service.enumDeclareServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 枚举词典
 * **/
@Controller
@RequestMapping("webGetr/enumDeclareControl/")
public class enumDeclareControl {

    @Autowired
    enumDeclareServ enumdeclareserv;

    /*枚举词典模糊查询*/
    @RequestMapping(value="baseEnumQuery.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String baseEnumQuery(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(enumdeclareserv.baseEnumQuery(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*基础枚举新增*/
    @RequestMapping(value="addEnumDicts.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addEnumDicts(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(enumdeclareserv.addEnumDicts(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }
}
