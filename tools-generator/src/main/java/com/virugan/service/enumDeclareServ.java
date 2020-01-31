package com.virugan.service;

import com.virugan.api.getrDynamicJdbcOperate;
import com.virugan.api.localJdbcOperate;
import com.virugan.constant.myBaseDeclare;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.tables.mytoolGetrEnumdict;
import com.virugan.tables.mytoolGetrEumdetil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class enumDeclareServ {
    @Autowired
    localJdbcOperate localjdbcOperate;
    @Autowired
    getrDynamicJdbcOperate dynamicJdbcOperate;

    @Value("${getr.currentproject}")
    private String currentproject;
    @Value("${getr.currentmodle}")
    private String currentmodle;

    /*基础枚举模糊查询*/
    public Map<String,Object> baseEnumQuery(Map<String,Object> ctxmap){

        mytoolGetrEnumdict inGetrEnumdict = myBeanUtils.mapToObject(ctxmap, mytoolGetrEnumdict.class);
        List<mytoolGetrEnumdict> resltlst = localjdbcOperate.
                                 selectListBySqlId(localjdbcOperate.NAME_SPACE+"GetrBaseEnumQuery", inGetrEnumdict);

        ctxmap.put(myBaseDeclare.resltlst,resltlst);

        return ctxmap;
    }

    /*枚举明细查询*/
    public Map<String,Object> enumDetailQuery(Map<String,Object> ctxmap){

        mytoolGetrEnumdict inGetrEnumdict = myBeanUtils.mapToObject(ctxmap, mytoolGetrEnumdict.class);
        inGetrEnumdict.setBelgprjt(currentproject);
        inGetrEnumdict.setBelgmodl(currentmodle);

        mytoolGetrEnumdict resulEnumdict = localjdbcOperate.selectByPrimaryKey(inGetrEnumdict);
        Map<String, Object> resulMap = myBeanUtils.objectToMap(resulEnumdict);

        if(resulMap!=null){
            ctxmap.putAll(resulMap);
        }

        mytoolGetrEumdetil inGetrEnumdetil = myBeanUtils.mapToObject(ctxmap, mytoolGetrEumdetil.class);

        List<mytoolGetrEumdetil> resltlst = localjdbcOperate.selectListByInput(inGetrEnumdetil);

        ctxmap.put(myBaseDeclare.resltlst,resltlst);

        return ctxmap;
    }

    /*新增枚举明细*/
    public Map<String,Object> addEnumDetails(Map<String,Object> ctxmap){

        mytoolGetrEumdetil inGetrEnumdetil = myBeanUtils.mapToObject(ctxmap, mytoolGetrEumdetil.class);
        inGetrEnumdetil.setBelgprjt(currentproject);
        inGetrEnumdetil.setBelgmodl(currentmodle);

        localjdbcOperate.insert(inGetrEnumdetil);
        dynamicJdbcOperate.insert(inGetrEnumdetil);

        return ctxmap;
    }

    /*基础枚举新增*/
    public Map<String,Object> addEnumDicts(Map<String,Object> ctxmap){

        mytoolGetrEnumdict inGetrEnumdict = myBeanUtils.mapToObject(ctxmap, mytoolGetrEnumdict.class);
        inGetrEnumdict.setBelgprjt(currentproject);
        inGetrEnumdict.setBelgmodl(currentmodle);

        localjdbcOperate.insert(inGetrEnumdict);
        dynamicJdbcOperate.insert(inGetrEnumdict);

        return ctxmap;
    }
}
