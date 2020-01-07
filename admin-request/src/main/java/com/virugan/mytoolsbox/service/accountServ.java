package com.virugan.mytoolsbox.service;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.dao.publicDao;
import com.virugan.mytoolsbox.entry.*;
import com.virugan.mytoolsbox.mapper.myAccountAnalysMapper;
import com.virugan.mytoolsbox.mapper.myAccountDetailMapper;
import com.virugan.mytoolsbox.mapper.myTpublicParamsMapper;
import com.virugan.mytoolsbox.utils.CSVUtils;
import com.virugan.mytoolsbox.utils.myBeanUtils;
import com.virugan.mytoolsbox.utils.myDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * 账单操作
 * @author haoyl
 * @version 2019-07-27
 */
@Service
public class accountServ {

    @Autowired
    myAccountDetailMapper myaccountdetailMapper;
    @Autowired
    myTpublicParamsMapper mytpublicParamsMapper;
    @Autowired
    publicDao publicdao;
    @Autowired
    myAccountAnalysMapper myaccountAnalysMapper;

    public myAccountAnalys findLockMonth(myAccountAnalys accountAnalys){
        myAccountAnalysExample myAccountAnalysExample = new myAccountAnalysExample();
        com.virugan.mytoolsbox.entry.myAccountAnalysExample.Criteria criteria = myAccountAnalysExample.createCriteria();
        if(accountAnalys.getChckFlag()!=null){
            criteria.andChckFlagEqualTo(accountAnalys.getChckFlag());
        }
        if(accountAnalys.getTranDate()!=null){
            criteria.andTranDateEqualTo(accountAnalys.getTranDate());
        }
        List<myAccountAnalys> analysList = myaccountAnalysMapper.selectByExample(myAccountAnalysExample);
        if(analysList.size()<0){
            return new myAccountAnalys();
        }
        return analysList.get(0);
    }

    public void accountDetailEdit(myAccountDetail detail,String flag){
        String[] s = detail.getTranDate().split(" ");
        if(s.length>1){
            detail.setTranDate(s[0]);
            detail.setTranTime(s[1]);
        }else{
            detail.setTranTime("00:00:00");
        }

        if(flag.equals("ADD")){

            detail.setColsNumb(publicdao.getIndexByName("accountIndex"));
            detail.setFileType("person");
            detail.setTranFlag("支付成功");
            detail.setTranNumb("T"+System.currentTimeMillis());
            detail.setObjtNumb(System.currentTimeMillis()+"");
            myaccountdetailMapper.insert(detail);

        }else if(flag.equals("UPD")){
            detail.setTranFlag("支付成功");

            myAccountDetailExample myAccountDetailExample = new myAccountDetailExample();
            com.virugan.mytoolsbox.entry.myAccountDetailExample.Criteria criteria = myAccountDetailExample.createCriteria();
            criteria.andColsNumbEqualTo(detail.getColsNumb());

            List<myAccountDetail> myAccountDetails = myaccountdetailMapper.selectByExample(myAccountDetailExample);
            detail.setTranNumb(myAccountDetails.get(0).getTranNumb());
            detail.setObjtNumb(myAccountDetails.get(0).getObjtNumb());

            myaccountdetailMapper.updateByExample(detail,myAccountDetailExample);

        }else if(flag.equals("DEL")){
            if(detail.getColsNumb()==null){
                return;
            }

            myAccountDetailExample myAccountDetailExample = new myAccountDetailExample();
            com.virugan.mytoolsbox.entry.myAccountDetailExample.Criteria criteria = myAccountDetailExample.createCriteria();
            criteria.andColsNumbEqualTo(detail.getColsNumb());
            myaccountdetailMapper.deleteByExample(myAccountDetailExample);
        }
    }

    public void sumgetsSave(String tranDate,String sumsGets){
        myAccountAnalysExample myAccountAnalysExample = new myAccountAnalysExample();
        com.virugan.mytoolsbox.entry.myAccountAnalysExample.Criteria criteria = myAccountAnalysExample.createCriteria();
        criteria.andTranDateEqualTo(tranDate);
        List<myAccountAnalys> analysList = myaccountAnalysMapper.selectByExample(myAccountAnalysExample);
        myAccountAnalys accountAnalys;
        if(analysList.size()<=0){
            accountAnalys = new myAccountAnalys();
            accountAnalys.setTranDate(tranDate);
            accountAnalys.setCritPays("0");
            accountAnalys.setFoodPays("0");
            accountAnalys.setHousPays("0");
            accountAnalys.setLiftPays("0");
            accountAnalys.setPlayPays("0");
            accountAnalys.setSavePays("0");
            accountAnalys.setShopPays("0");
            accountAnalys.setSumsGets("0");
            accountAnalys.setSumsPays("0");
            accountAnalys.setTbigPays("0");
            accountAnalys.setTnetProf("0");
            accountAnalys.setTpayBack("0");
            accountAnalys.setTrafPays("0");
            accountAnalys.setOthrPays("0");
            myaccountAnalysMapper.insert(accountAnalys);
        }else{
            accountAnalys=analysList.get(0);
        }
        accountAnalys.setSumsGets(sumsGets);
        publicdao.updateAnalysUnSelected();
        accountAnalys.setChckFlag("SELECTED");
        myaccountAnalysMapper.updateByExample(accountAnalys,myAccountAnalysExample);
    }

    public void analysisData(String date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDateUtils.toDate(date,"yyyy-MM-dd"));
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

        cal.add(Calendar.MONTH, -2);
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

        //获取交易日期数据,如果没有则插入条新纪录
        myAccountAnalysExample myAccountAnalysExample = new myAccountAnalysExample();
        com.virugan.mytoolsbox.entry.myAccountAnalysExample.Criteria criteria = myAccountAnalysExample.createCriteria();
        criteria.andTranDateEqualTo(date);
        List<myAccountAnalys> analysList = myaccountAnalysMapper.selectByExample(myAccountAnalysExample);
        if(analysList.size()<=0){
            myAccountAnalys accountAnalys = new myAccountAnalys();
            accountAnalys.setTranDate(date);
            accountAnalys.setCritPays("0");
            accountAnalys.setFoodPays("0");
            accountAnalys.setHousPays("0");
            accountAnalys.setLiftPays("0");
            accountAnalys.setPlayPays("0");
            accountAnalys.setSavePays("0");
            accountAnalys.setShopPays("0");
            accountAnalys.setSumsGets("0");
            accountAnalys.setSumsPays("0");
            accountAnalys.setTbigPays("0");
            accountAnalys.setTnetProf("0");
            accountAnalys.setTpayBack("0");
            accountAnalys.setTrafPays("0");
            accountAnalys.setOthrPays("0");
            publicdao.updateAnalysUnSelected();
            accountAnalys.setChckFlag("SELECTED");
            myaccountAnalysMapper.insert(accountAnalys);
        }

        System.out.println(String.format("accountDayStart [%s],accountDayEnd [%s]",accountDayStart,accountDayEnd));
        System.out.println(String.format("saveDayStart [%s],saveDayEnd [%s]",saveDayStart,saveDayEnd));


        BigDecimal critPays = myaccountdetailMapper.selectSumAmtsByExample("tran_date < '"+accountDayEnd+"' and tran_date >= '"+accountDayStart+"' and item_type = '信用账户'");

        BigDecimal savePays = myaccountdetailMapper.selectSumAmtsByExample("tran_date < '"+saveDayEnd+"' and tran_date >= '"+saveDayStart+"' and item_type = '储蓄账户'");

        BigDecimal sumsPays =critPays.add(savePays);

        List<Map<String,Object>> critPaysList = myaccountdetailMapper.selectSumAmtsByExampleGroup("tran_date < '" + accountDayEnd + "' and tran_date >= '" + accountDayStart + "' and item_type = '信用账户'");
        List<Map<String,Object>> savePaysList = myaccountdetailMapper.selectSumAmtsByExampleGroup("tran_date < '"+saveDayEnd+"' and tran_date >= '"+saveDayStart+"' and item_type = '储蓄账户'");
        Map<String, Object> AmtsMap = myBeanUtils.getMap();
        for (Map<String,Object> map:critPaysList){
            AmtsMap.put((String) map.get("grop_type"),new BigDecimal(String.valueOf(map.get("tran_amts"))).setScale(1,BigDecimal.ROUND_HALF_UP));
        }
        for(Map<String,Object> map:savePaysList){
            String key=(String) map.get("grop_type");
            if(AmtsMap.containsKey(key)){
                AmtsMap.put(key,((BigDecimal)AmtsMap.get(key)).add(new BigDecimal(String.valueOf(map.get("tran_amts")))).setScale(1,BigDecimal.ROUND_HALF_UP));
            }else{
                AmtsMap.put(key,new BigDecimal(String.valueOf(map.get("tran_amts"))).setScale(1,BigDecimal.ROUND_HALF_UP));
            }
        }



        myAccountAnalys acctAnalys =  new myAccountAnalys();
        acctAnalys.setTranDate(date);
        acctAnalys.setCritPays(critPays.toPlainString());
        acctAnalys.setSavePays(savePays.toPlainString());
        acctAnalys.setSumsPays(sumsPays.toPlainString());

        if(analysList.size()>0){
            acctAnalys.setSumsGets(analysList.get(0).getSumsGets());
        }

        for(String key : AmtsMap.keySet()){
            if(key.equals("交通费")){
                acctAnalys.setTrafPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("伙食费")){
                acctAnalys.setFoodPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("大宗消费")){
                acctAnalys.setTbigPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("娱乐消费")){
                acctAnalys.setPlayPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("房租")){
                acctAnalys.setHousPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("购物")){
                acctAnalys.setShopPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("生活费")){
                acctAnalys.setLiftPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("未处理")){
                acctAnalys.setOthrPays(String.valueOf(AmtsMap.get(key)));
            }else if(key.equals("还款")){
                acctAnalys.setTpayBack(String.valueOf(AmtsMap.get(key)));
            }
        }
        publicdao.updateAnalysUnSelected();
        acctAnalys.setChckFlag("SELECTED");

        //求净利润
        String sumsGets = acctAnalys.getSumsGets();
        if(sumsGets==null||sumsGets.equals("")){
            sumsGets="0";
        }
        if(sumsPays==null||sumsPays.equals("")){
            sumsPays=BigDecimal.ZERO;
        }
        String tnetProf=new BigDecimal(sumsGets).subtract(sumsPays).toPlainString();
        acctAnalys.setTnetProf(tnetProf);

        System.out.println(String.format("acctAnalys [%s]",myBeanUtils.objectToMap(acctAnalys)));
        myaccountAnalysMapper.updateByExample(acctAnalys,myAccountAnalysExample);
    }

    public myAccountAnalys mappingToAnalysis(){
        myAccountAnalysExample myAccountAnalysExample = new myAccountAnalysExample();
        com.virugan.mytoolsbox.entry.myAccountAnalysExample.Criteria criteria = myAccountAnalysExample.createCriteria();
        criteria.andChckFlagEqualTo("SELECTED");
        List<myAccountAnalys> analysList = myaccountAnalysMapper.selectByExample(myAccountAnalysExample);
        if(analysList.size()<=0){
            String date = myDateUtils.format(new Date(), "yyyy-MM-dd");
            date=date.substring(0,8)+"01";
            myAccountAnalys accountAnalys = new myAccountAnalys();
            accountAnalys.setTranDate(date);
            accountAnalys.setCritPays("0");
            accountAnalys.setFoodPays("0");
            accountAnalys.setHousPays("0");
            accountAnalys.setLiftPays("0");
            accountAnalys.setPlayPays("0");
            accountAnalys.setSavePays("0");
            accountAnalys.setShopPays("0");
            accountAnalys.setSumsGets("0");
            accountAnalys.setSumsPays("0");
            accountAnalys.setTbigPays("0");
            accountAnalys.setTnetProf("0");
            accountAnalys.setTpayBack("0");
            accountAnalys.setTrafPays("0");
            accountAnalys.setOthrPays("0");
            publicdao.updateAnalysUnSelected();
            accountAnalys.setChckFlag("SELECTED");
            myaccountAnalysMapper.insert(accountAnalys);
            return accountAnalys;
        }else {
            return analysList.get(0);
        }
    }

    //导入文件后续处理
    public void impDataAfter(){
        myTpublicParamsExample myTpublicParamsExample = new myTpublicParamsExample();
        com.virugan.mytoolsbox.entry.myTpublicParamsExample.Criteria criteria = myTpublicParamsExample.createCriteria();
        criteria.andParaTypeEqualTo("impDataAfter");
        List<myTpublicParams> paramsList = mytpublicParamsMapper.selectByExample(myTpublicParamsExample);
        for (myTpublicParams param:paramsList){
            mytpublicParamsMapper.executeSql(param.getParaValu());
        }

    }

    public myContext findDetailsByCondition (HttpSession httpSession, myAccountDetail detail){

        String tranDate =detail.getTranDate();
        if(tranDate==null||tranDate.equals("")){
            tranDate =(String)httpSession.getAttribute("tranDate");
        }else{
            httpSession.setAttribute("tranDate",detail.getTranDate());
        }
        if(tranDate==null||tranDate.equals("")){
            myAccountAnalys accountAnalys = publicdao.getAnalysSelected();
            tranDate=accountAnalys.getTranDate();
            httpSession.setAttribute("tranDate",tranDate);
        }

        String itemType=detail.getItemType();
        if(detail.getItemType()==null||detail.getItemType().equals("")){
            itemType =(String)httpSession.getAttribute("itemType");
        }else{
            httpSession.setAttribute("itemType",detail.getItemType());
        }
        if(itemType==null||itemType.equals("")){
            itemType="全部";
            httpSession.setAttribute("itemType",itemType);
        }

        if(itemType.equals("储蓄账户")){
            List<String> saveAcctBetweenDate = publicdao.getSaveAcctBetweenDate(tranDate);
            List<myAccountDetail> myAccountDetails = myaccountdetailMapper.selectByNameSql("tran_date < '" + saveAcctBetweenDate.get(1) + "' and tran_date >= '" + saveAcctBetweenDate.get(0) + "' and item_type = '储蓄账户'");
            myContext mycontext = myContext.getInstance();
            mycontext.put("itemType",itemType);
            mycontext.put("tranDate",tranDate);
            mycontext.put(myContext.MYLIST,myAccountDetails);
            return mycontext;
        }else if(itemType.equals("信用账户")){
            List<String> creditAcctBetweenDate = publicdao.getCreditAcctBetweenDate(tranDate);
            List<myAccountDetail> myAccountDetails = myaccountdetailMapper.selectByNameSql("tran_date < '" + creditAcctBetweenDate.get(1) + "' and tran_date >= '" + creditAcctBetweenDate.get(0) + "' and item_type = '信用账户'");
            myContext mycontext = myContext.getInstance();
            mycontext.put("itemType",itemType);
            mycontext.put("tranDate",tranDate);
            mycontext.put(myContext.MYLIST,myAccountDetails);
            return mycontext;
        }else{
            List<myAccountDetail> myAccountDetails = new ArrayList<>();
            List<String> saveAcctBetweenDate = publicdao.getSaveAcctBetweenDate(tranDate);
            List<String> creditAcctBetweenDate = publicdao.getCreditAcctBetweenDate(tranDate);
            List<myAccountDetail> saveAcctDetails = myaccountdetailMapper.selectByNameSql("tran_date < '" + saveAcctBetweenDate.get(1) + "' and tran_date >= '" + saveAcctBetweenDate.get(0) + "' and item_type = '储蓄账户'");
            List<myAccountDetail> creditAcctDetails = myaccountdetailMapper.selectByNameSql("tran_date < '" + creditAcctBetweenDate.get(1) + "' and tran_date >= '" + creditAcctBetweenDate.get(0) + "' and item_type = '信用账户'");
            myAccountDetails.addAll(saveAcctDetails);
            myAccountDetails.addAll(creditAcctDetails);
            myContext mycontext = myContext.getInstance();
            mycontext.put("itemType",itemType);
            mycontext.put("tranDate",tranDate);
            mycontext.put(myContext.MYLIST,myAccountDetails);
            return mycontext;
        }

    }

    public List<myAccountDetail> selectDetail(myAccountDetail detail){

        myAccountDetailExample accountDetailExample = new myAccountDetailExample();
        myAccountDetailExample.Criteria criteria = accountDetailExample.createCriteria();
        if(detail.getColsNumb()!=null){
            criteria.andColsNumbEqualTo(detail.getColsNumb());
        }

        if(detail.getTranDate()!=null){
            criteria.andTranDateEqualTo(detail.getTranDate());
        }
        if(detail.getGropType()!=null){
            criteria.andGropTypeEqualTo(detail.getGropType());
        }

        return myaccountdetailMapper.selectByExample(accountDetailExample);
    }
    public boolean impDataForAlPay(File filNme){

        final List<String> datalist = CSVUtils.importCsv(filNme,"GBK");
        for (String line:datalist){
            final String[] as = line.split(",");
            if(as.length>10 && !as[0].trim().equals("交易号")){
                String[] timp = as[2].split(" ");

                myAccountDetailExample myAccountDetailExample = new myAccountDetailExample();
                com.virugan.mytoolsbox.entry.myAccountDetailExample.Criteria criteria = myAccountDetailExample.createCriteria();
                criteria.andTranDateEqualTo(timp[0]);
                criteria.andTranNumbEqualTo("T"+as[0].trim());
                criteria.andFileTypeEqualTo(myContents.ALPAYS);
                criteria.andTranAmtsEqualTo(new Double(as[9]));
                if(as[10].equals("支出")){
                    criteria.andTranDictEqualTo("借");
                }else if(as[10].equals("收入")){
                    criteria.andTranDictEqualTo("贷");
                }
                List<myAccountDetail> list = myaccountdetailMapper.selectByExample(myAccountDetailExample);
                if(list.size()>0){
                    continue;
                }

                myAccountDetail myaccount_detail = new myAccountDetail();
                myaccount_detail.setFileName(filNme.getName());
                myaccount_detail.setTranDate(timp[0]);
                myaccount_detail.setTranTime(timp[1]);
                myaccount_detail.setTranType(as[6]);
                myaccount_detail.setTranObjt(as[7]);
                myaccount_detail.setTranGood(as[8]);
                if(as[10].trim().equals("支出")){
                    myaccount_detail.setTranDict("借");
                }else if(as[10].trim().equals("收入")){
                    myaccount_detail.setTranDict("贷");
                }
                myaccount_detail.setTranAmts(new Double(as[9]));
                myaccount_detail.setTranFlag(as[11]);
                myaccount_detail.setTranNumb("T"+as[0].trim());
                myaccount_detail.setObjtNumb(as[1]);
                myaccount_detail.setPaytNums("支付宝");
                myaccount_detail.setColsNumb(publicdao.getIndexByName("accountIndex"));
                myaccount_detail.setFileType(myContents.ALPAYS);

                myaccountdetailMapper.insert(myaccount_detail);
            }
        }

        return true;
    }

    public boolean impDataForWeixin(File filNme){

        final List<String> datalist = CSVUtils.importCsv(filNme,"UTF-8");
        for (String line:datalist){
            final String[] as = line.split(",");
            if(as.length>10 && !as[0].equals("交易时间")){
                String[] timp = as[0].split(" ");

                myAccountDetailExample myAccountDetailExample = new myAccountDetailExample();
                com.virugan.mytoolsbox.entry.myAccountDetailExample.Criteria criteria = myAccountDetailExample.createCriteria();
                criteria.andTranDateEqualTo(timp[0]);
                criteria.andTranNumbEqualTo("T"+as[8].trim());
                criteria.andFileTypeEqualTo(myContents.WEIXIN);
                criteria.andTranAmtsEqualTo(new Double(as[5].substring(1)));
                if(as[4].equals("支出")){
                    criteria.andTranDictEqualTo("借");
                }else if(as[4].equals("收入")){
                    criteria.andTranDictEqualTo("贷");
                }
                List<myAccountDetail> list = myaccountdetailMapper.selectByExample(myAccountDetailExample);
                if(list.size()>0){
                    continue;
                }

                myAccountDetail myaccount_detail = new myAccountDetail();
                myaccount_detail.setFileName(filNme.getName());
                myaccount_detail.setTranDate(timp[0]);
                myaccount_detail.setTranTime(timp[1]);
                myaccount_detail.setTranType(as[1]);
                myaccount_detail.setTranObjt(as[2]);
                myaccount_detail.setTranGood(as[3]);
                if(as[4].equals("支出")){
                    myaccount_detail.setTranDict("借");
                }else if(as[4].equals("收入")){
                    myaccount_detail.setTranDict("贷");
                }
                myaccount_detail.setTranAmts(new Double(as[5].substring(1)));
                myaccount_detail.setPaytNums(as[6]);
                myaccount_detail.setTranFlag(as[7]);
                myaccount_detail.setTranNumb("T"+as[8].trim());
                myaccount_detail.setObjtNumb(as[9]);
                myaccount_detail.setColsNumb(publicdao.getIndexByName("accountIndex"));
                myaccount_detail.setFileType(myContents.WEIXIN);

                myaccountdetailMapper.insert(myaccount_detail);
            }
        }

        return true;
    }
}
