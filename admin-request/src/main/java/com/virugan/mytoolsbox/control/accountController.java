package com.virugan.mytoolsbox.control;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.entry.myAccountAnalys;
import com.virugan.mytoolsbox.entry.myAccountDetail;
import com.virugan.mytoolsbox.service.accountServ;
import com.virugan.mytoolsbox.utils.CSVUtils;
import com.virugan.mytoolsbox.utils.myBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class accountController {

    @Autowired
    accountServ accountserv;

    @RequestMapping(value="accountController.onSelectDetailsChange.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String onSelectDetailsChange(HttpSession httpSession, myAccountDetail detail){
        myContents.log("accountController.onSelectDetailsChange start ----");
        myContents.log(String.format("httpSession [%s] detail [%s]", httpSession,myBeanUtils.objectToMap(detail)));

        httpSession.setAttribute("tranDate",detail.getTranDate());
        httpSession.setAttribute("itemType",detail.getItemType());

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("accountController.onSelectDetailsChange end ----");
        return mycontext.toJson();
    }

    //按照指定条件查找账单明细
    @RequestMapping(value="accountController.findDetailsByCondition.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findDetailsByCondition(HttpSession httpSession, myAccountDetail detail){
        myContents.log("accountController.findDetailsByCondition start ----");
        myContents.log(String.format("httpSession [%s] detail [%s]", httpSession,myBeanUtils.objectToMap(detail)));

        myContext mycontext = accountserv.findDetailsByCondition(httpSession,detail);

        myContents.log("accountController.findDetailsByCondition end ----");
        return mycontext.toJson();
    }

    //查询当前锁定月份及收入
    @RequestMapping(value="accountController.findLockMonth.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findLockMonth(myAccountAnalys accountAnalys){
        myContents.log("accountController.findLockMonth start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(accountAnalys)));

        myAccountAnalys lockMonth = accountserv.findLockMonth(accountAnalys);

        myContext mycontext = myContext.getInstance();
        mycontext.put("lockMonth",lockMonth);
        myContents.log("accountController.findLockMonth end ----");
        return mycontext.toJson();
    }

    //补录修改账单明细
    @RequestMapping(value="accountController.accountDetailEdit.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String accountDetailEdit(myAccountDetail detail,String flag){
        myContents.log("accountController.accountDetailEdit start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(detail)));

        accountserv.accountDetailEdit(detail, flag);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("accountController.accountDetailEdit end ----");
        return mycontext.toJson();
    }

    //更改当前查询月份、收入
    @RequestMapping(value="accountController.sumgetsSave.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String sumgetsSave(String tranDate,String sumsGets){
        myContents.log("accountController.sumgetsSave start ----");
        myContents.log(String.format("tranDate[%s]，sumsGets[%s]",tranDate,sumsGets));

        accountserv.sumgetsSave(tranDate,sumsGets);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("accountController.sumgetsSave end ----");
        return mycontext.toJson();
    }

    //执行统计分析分析当月消费情况
    @RequestMapping(value="accountController.analysisData.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String analysisData(String tranDate){
        myContents.log("accountController.analysisData start ----");
        myContents.log(String.format("[%s]",tranDate));
        accountserv.analysisData(tranDate);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("accountController.analysisData end ----");
        return mycontext.toJson();
    }

    //导入微信、支付宝账单
    @RequestMapping(value="accountController.impdpAccount.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String impdpAccount(String accType,String url){
        myContents.log("accountController.impdpAccount start ----");
        myContents.log(String.format("[%s],[%s]",accType,url));
        myContext mycontext = myContext.getInstance();
        try {
            if(accType.equals(myContents.WEIXIN)){
                accountserv.impDataForWeixin(new File(url));
            }else if(accType.equals(myContents.ALPAYS)){
                accountserv.impDataForAlPay(new File(url));
            }

            //导入文件后续处理
            accountserv.impDataAfter();

            mycontext.put(myContext.RESULT,myContents.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            mycontext.put(myContext.RESULT,e.getMessage());
        }



        myContents.log(String.format("[%s]",mycontext));
        myContents.log("accountController.impdpAccount end ----");
        return mycontext.toJson();
    }


    //查找账单明细
    @RequestMapping(value="accountController.selectDetail.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String selectDetail (myAccountDetail detail){
        myContents.log("accountController.selectDetail start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(detail)));

        List<myAccountDetail> myList = accountserv.selectDetail(detail);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,myList);
        myContents.log("accountController.selectDetail end ----");
        return mycontext.toJson();
    }
}
