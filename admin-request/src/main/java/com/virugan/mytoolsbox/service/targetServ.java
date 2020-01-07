package com.virugan.mytoolsbox.service;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.dao.publicDao;
import com.virugan.mytoolsbox.entry.myAccountParams;
import com.virugan.mytoolsbox.entry.myAccountParamsExample;
import com.virugan.mytoolsbox.mapper.myAccountParamsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class targetServ {

    @Autowired
    myAccountParamsMapper myaccountParamsMapper;
    @Autowired
    publicDao publicdao;

    public boolean addTarget(myAccountParams params){
        Integer targetIndex = publicdao.getIndexByName("targetIndex");
        params.setColsNumb(targetIndex);
        myaccountParamsMapper.insert(params);
        return true;
    }

    public List<myAccountParams> selectTarget(myAccountParams params){
        myAccountParamsExample myAccountParamsExample = new myAccountParamsExample();
        com.virugan.mytoolsbox.entry.myAccountParamsExample.Criteria criteria = myAccountParamsExample.createCriteria();
        if(params.getColsNumb()!=null){
            criteria.andColsNumbEqualTo(params.getColsNumb());
        }
        return myaccountParamsMapper.selectByExample(myAccountParamsExample);
    }

    public boolean deleteTarget(myAccountParams params){
        myAccountParamsExample myAccountParamsExample = new myAccountParamsExample();
        com.virugan.mytoolsbox.entry.myAccountParamsExample.Criteria criteria = myAccountParamsExample.createCriteria();

        if (params.getColsNumb()!=null){
            criteria.andColsNumbEqualTo(params.getColsNumb());
        }else{
            return false;
        }

        if (params.getParaType()!=null){
            criteria.andParaTypeEqualTo(params.getParaType());
        }
        myaccountParamsMapper.deleteByExample(myAccountParamsExample);
        return true;
    }

    public boolean updateTarget(myAccountParams params){
        myAccountParamsExample myAccountParamsExample = new myAccountParamsExample();
        com.virugan.mytoolsbox.entry.myAccountParamsExample.Criteria criteria = myAccountParamsExample.createCriteria();

        if (params.getColsNumb()!=null){
            criteria.andColsNumbEqualTo(params.getColsNumb());
        }else{
            return false;
        }

        myaccountParamsMapper.updateByExample(params,myAccountParamsExample);
        return true;
    }

    public Integer execTarget(myAccountParams params){
        myAccountParamsExample myAccountParamsExample = new myAccountParamsExample();
        com.virugan.mytoolsbox.entry.myAccountParamsExample.Criteria criteria = myAccountParamsExample.createCriteria();

        if(params.getColsNumb()!=null){
            criteria.andColsNumbEqualTo(params.getColsNumb());
        }
        List<myAccountParams> paramsList = myaccountParamsMapper.selectByExample(myAccountParamsExample);
        Integer numb=0;
        for (myAccountParams param:paramsList){
            myContents.log("exec:"+param.getSqlsValu());
            myaccountParamsMapper.executeSql(param.getSqlsValu());
            numb=numb+1;
        }

        return numb;
    }
}
