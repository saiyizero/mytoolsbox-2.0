package com.virugan.mytoolsbox.control;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.entry.myAccountParams;
import com.virugan.mytoolsbox.service.targetServ;
import com.virugan.mytoolsbox.utils.myBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class targetController {

    @Autowired
    targetServ targetserv;

    @RequestMapping(value="targetController.addTarget.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addTarget(myAccountParams params){
        myContents.log("targetController.addTarget start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(params)));

        targetserv.addTarget(params);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT, myContents.SUCCESS);
        myContents.log("targetController.addTarget end ----");
        return mycontext.toJson();
    }

    @RequestMapping(value="targetController.selectTarget.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String selectTarget(myAccountParams params){
        myContents.log("targetController.selectTarget start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(params)));

        List<myAccountParams> myList = targetserv.selectTarget(params);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST, myList);
        myContents.log("targetController.selectTarget end ----");
        return mycontext.toJson();
    }

    @RequestMapping(value="targetController.deleteTarget.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteTarget(myAccountParams params){
        myContents.log("targetController.deleteTarget start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(params)));

        targetserv.deleteTarget(params);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT, myContents.SUCCESS);
        myContents.log("targetController.deleteTarget end ----");
        return mycontext.toJson();
    }

    @RequestMapping(value="targetController.updateTarget.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateTarget(myAccountParams params){
        myContents.log("targetController.updateTarget start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(params)));

        targetserv.updateTarget(params);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT, myContents.SUCCESS);
        myContents.log("targetController.updateTarget end ----");
        return mycontext.toJson();
    }

    @RequestMapping(value="targetController.execTarget.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String execTarget(myAccountParams params){
        myContents.log("targetController.execTarget start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(params)));

        Integer numb = targetserv.execTarget(params);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT, numb);
        myContents.log("targetController.execTarget end ----");
        return mycontext.toJson();
    }
}
