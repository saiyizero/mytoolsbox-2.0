package com.virugan.api;

import com.virugan.constant.myBaseEnume;
import com.virugan.tables.mytoolConfDatcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地数据缓存
 * **/

@Component
public class localDataCache {

    @Autowired
    localJdbcOperate jdbcOperate;

    //获取缓存路径
    public String getPathByName(String pathName){
        mytoolConfDatcache confDatcache = new mytoolConfDatcache();
        confDatcache.setCachname(pathName);
        confDatcache.setCachtype(myBaseEnume.E_CACHTYPE.FILEPATH.getVaule());

        List<mytoolConfDatcache> tpublicParams = jdbcOperate.selectListByInput(confDatcache);
        if(tpublicParams.size()>0){
            return tpublicParams.get(0).getCachvalu();
        }else{
            return null;
        }
    }

    //设置缓存路径
    public boolean setPathByName(String pathName,String pathValue){
        mytoolConfDatcache confDatcache = new mytoolConfDatcache();
        confDatcache.setCachname(pathName);
        confDatcache.setCachtype(myBaseEnume.E_CACHTYPE.FILEPATH.getVaule());

        List<mytoolConfDatcache> tpublicParams = jdbcOperate.selectListByInput(confDatcache);
        if(tpublicParams.size()>0){
            mytoolConfDatcache myTpublicParams = tpublicParams.get(0);
            myTpublicParams.setCachvalu(pathValue);
            jdbcOperate.updateByPrimaryKey(myTpublicParams);
        }else{
            mytoolConfDatcache myTpublicParams=new mytoolConfDatcache();
            myTpublicParams.setCachvalu(pathValue);
            myTpublicParams.setCachname(pathName);
            confDatcache.setCachtype(myBaseEnume.E_CACHTYPE.FILEPATH.getVaule());
            jdbcOperate.insert(myTpublicParams);
        }
        return true;
    }

    //递增序号获取
    public Integer getSequenceByName(String seqName){
        Integer numbers;
        mytoolConfDatcache myTpublicParams;

        mytoolConfDatcache confDatcache = new mytoolConfDatcache();
        confDatcache.setCachname(seqName);
        confDatcache.setCachtype(myBaseEnume.E_CACHTYPE.SEQUENCE.getVaule());

        List<mytoolConfDatcache> tpublicParams = jdbcOperate.selectListByInput(confDatcache);
        if(tpublicParams.size()>0){
            myTpublicParams = tpublicParams.get(0);
            numbers=new Integer(myTpublicParams.getCachvalu());
            myTpublicParams.setCachvalu(String.valueOf(numbers+1));
            jdbcOperate.updateByPrimaryKey(myTpublicParams);
        }else{
            numbers=1;
            myTpublicParams=new mytoolConfDatcache();
            myTpublicParams.setCachname(seqName);
            myTpublicParams.setCachtype(myBaseEnume.E_CACHTYPE.SEQUENCE.getVaule());
            myTpublicParams.setCachvalu(String.valueOf(numbers+1));
            jdbcOperate.insert(myTpublicParams);
        }

        return numbers;
    }
}
