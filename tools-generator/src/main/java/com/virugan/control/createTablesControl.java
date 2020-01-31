package com.virugan.control;

import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.myUtlis.myJsonUtils;
import com.virugan.service.createTablesServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 新增表维护维护新增表、删除表
 * **/

@Controller
@RequestMapping("webGetr/createTablesControl/")
public class createTablesControl {

    @Autowired
    createTablesServ createtablesserv;

    /*登陆时载入表结构*/
    @RequestMapping(value="queryTables.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryTables(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(createtablesserv.queryTables(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }
}
