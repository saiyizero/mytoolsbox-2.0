package com.virugan.mytoolsbox.dao;

import com.virugan.mytoolsbox.entry.myAccountAnalys;
import com.virugan.mytoolsbox.entry.myAccountAnalysExample;
import com.virugan.mytoolsbox.entry.myTpublicParams;
import com.virugan.mytoolsbox.entry.myTpublicParamsExample;
import com.virugan.mytoolsbox.mapper.myAccountAnalysMapper;
import com.virugan.mytoolsbox.mapper.myTpublicParamsMapper;
import com.virugan.mytoolsbox.utils.myDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class publicDao {

    @Autowired
    myTpublicParamsMapper mytpublicParamsMapper;
    @Autowired
    myAccountAnalysMapper myaccountAnalysMapper;

    public List<String> getSaveAcctBetweenDate(String transDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDateUtils.toDate(transDate,"yyyy-MM-dd"));
        cal.add(Calendar.MONTH, +1);

        String nowmonth = String.valueOf(cal.get(Calendar.MONTH));
        String nowyear  = String.valueOf(cal.get(Calendar.YEAR));
        if(nowmonth.length()<2){
            nowmonth="0"+nowmonth;
        }

        cal.add(Calendar.MONTH, +1);
        String nextmonth = String.valueOf(cal.get(Calendar.MONTH));
        String nextyear = String.valueOf(cal.get(Calendar.YEAR));
        if(nextmonth.length()<2){
            nextmonth="0"+nextmonth;
        }
        //获取储蓄记账起始日期
        String saveDayStart=nowyear+"-"+nowmonth+"-01";
        //获取储蓄记账结束日期
        String saveDayEnd=nextyear+"-"+nextmonth+"-01";

        List<String> list = new ArrayList<String>();
        list.add(saveDayStart);
        list.add(saveDayEnd);
        return list;
    }

    public List<String> getCreditAcctBetweenDate(String transDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDateUtils.toDate(transDate,"yyyy-MM-dd"));

        String month = String.valueOf(cal.get(Calendar.MONTH));
        if(month.length()<2){
            month="0"+month;
        }
        String year  = String.valueOf(cal.get(Calendar.YEAR));
        //获取上个月账单日
        String accountDayEnd=year+"-"+month+"-18";

        cal.add(Calendar.MONTH, -1);
        String lastmonth = String.valueOf(cal.get(Calendar.MONTH));
        if(lastmonth.length()<2){
            lastmonth="0"+lastmonth;
        }
        String lastyear  = String.valueOf(cal.get(Calendar.YEAR));
        //获取上上个月账单日
        String accountDayStart=lastyear+"-"+lastmonth+"-18";

        List<String> list = new ArrayList<String>();
        list.add(accountDayStart);
        list.add(accountDayEnd);
        return list;
    }

    public myAccountAnalys getAnalysSelected(){
        myAccountAnalysExample myAccountAnalysExample = new myAccountAnalysExample();
        com.virugan.mytoolsbox.entry.myAccountAnalysExample.Criteria criteria = myAccountAnalysExample.createCriteria();
        criteria.andChckFlagEqualTo("SELECTED");
        List<myAccountAnalys> analysList = myaccountAnalysMapper.selectByExample(myAccountAnalysExample);
        if(analysList.size()<=0){
            return new myAccountAnalys();
        }
        return analysList.get(0);
    }

    public void updateAnalysUnSelected(){
        String sql="UPDATE myaccount_analys SET chck_flag = null";
        mytpublicParamsMapper.executeSql(sql);
    }

    public Integer getIndexByName(String indexName){
        Integer numbers;
        myTpublicParams myTpublicParams;

        myTpublicParamsExample tpublicParamsExample = new myTpublicParamsExample();
        myTpublicParamsExample.Criteria criteria = tpublicParamsExample.createCriteria();
        criteria.andParaNameEqualTo(indexName);
        criteria.andParaTypeEqualTo("index");

        List<myTpublicParams> tpublicParams = mytpublicParamsMapper.selectByExample(tpublicParamsExample);
        if(tpublicParams.size()>0){
            myTpublicParams = tpublicParams.get(0);
            numbers=new Integer(myTpublicParams.getParaValu());
            myTpublicParams.setParaValu(String.valueOf(numbers+1));
            mytpublicParamsMapper.updateByExample(myTpublicParams,tpublicParamsExample);
        }else{
            numbers=1;
            myTpublicParams=new myTpublicParams();
            myTpublicParams.setParaName(indexName);
            myTpublicParams.setParaType("index");
            myTpublicParams.setParaValu(String.valueOf(numbers+1));
            mytpublicParamsMapper.insert(myTpublicParams);
        }

        return numbers;
    }

    public String getPathByName(String pathName){
        myTpublicParamsExample tpublicParamsExample = new myTpublicParamsExample();
        myTpublicParamsExample.Criteria criteria = tpublicParamsExample.createCriteria();
        criteria.andParaNameEqualTo(pathName);
        criteria.andParaTypeEqualTo("filPath");

        List<myTpublicParams> tpublicParams = mytpublicParamsMapper.selectByExample(tpublicParamsExample);
        if(tpublicParams.size()>0){
            return tpublicParams.get(0).getParaValu();
        }else{
            return null;
        }
    }

    public boolean setPathByName(String pathName,String pathValue){
        myTpublicParamsExample tpublicParamsExample = new myTpublicParamsExample();
        myTpublicParamsExample.Criteria criteria = tpublicParamsExample.createCriteria();
        criteria.andParaNameEqualTo(pathName);
        criteria.andParaTypeEqualTo("filPath");

        List<myTpublicParams> tpublicParams = mytpublicParamsMapper.selectByExample(tpublicParamsExample);
        if(tpublicParams.size()>0){
            myTpublicParams myTpublicParams = tpublicParams.get(0);
            myTpublicParams.setParaValu(pathValue);
            mytpublicParamsMapper.updateByExample(myTpublicParams,tpublicParamsExample);
        }else{
            myTpublicParams myTpublicParams=new myTpublicParams();
            myTpublicParams.setParaValu(pathValue);
            myTpublicParams.setParaName(pathName);
            myTpublicParams.setParaType("filPath");
            mytpublicParamsMapper.insert(myTpublicParams);
        }
        return true;
    }
}
