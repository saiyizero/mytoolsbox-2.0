package com.virugan.control;

import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.myUtlis.myJsonUtils;
import com.virugan.service.projectParamServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 定义项目初始化参数
 * **/
@Controller
@RequestMapping("webGetr/projectParamControl/")
public class projectParamControl {

    @Autowired
    projectParamServ projectparamserv;

    /*新增项目*/
    @RequestMapping(value="createProject.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String createProject(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(projectparamserv.createProject(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*修改项目配置*/
    @RequestMapping(value="updateProject.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateProject(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(projectparamserv.updateProject(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*删除项目配置并清理项目数据*/
    @RequestMapping(value="clearProject.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String clearProject(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(projectparamserv.clearProject(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*查询项目信息*/
    @RequestMapping(value="queryProjectMsg.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryProjectMsg(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(projectparamserv.queryProjectMsg(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

    /*查询项目列表*/
    @RequestMapping(value="queryProjectList.req",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryProjectList(@RequestParam Map<String,Object> ctxmap){

        ctxmap.putAll(projectparamserv.queryProjectList(ctxmap));
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(ctxmap);
    }

}
