package com.virugan.service;

import com.virugan.api.getrDynamicJdbcOperate;
import com.virugan.api.localJdbcOperate;
import com.virugan.component.myPages;
import com.virugan.constant.myBaseDeclare;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.tables.mytoolGetrBasedecl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class baseDeclareServ {

    @Value("${getr.currentproject}")
    private String currentproject;
    @Value("${getr.currentmodle}")
    private String currentmodle;

    @Autowired
    localJdbcOperate localjdbcOperate;
    @Autowired
    getrDynamicJdbcOperate dynamicJdbcOperate;

    /*基础字典全量查询*/
    public Map<String,Object> fuzzyQuery(Map<String,Object> ctxmap){
        mytoolGetrBasedecl mytoolGetrBasedecl = new mytoolGetrBasedecl();
        mytoolGetrBasedecl.setBelgprjt(currentproject);
        myPages mypages = myPages.getMyPagesFromMap(ctxmap);
        List<mytoolGetrBasedecl> resltlst = localjdbcOperate.selectListByInputForPage(mytoolGetrBasedecl, mypages);
        ctxmap.put(myBaseDeclare.resltlst,resltlst);
        ctxmap.put(myBaseDeclare.pagedata,mypages);
        return ctxmap;
    }

    /*基础字典模糊查询*/
    public Map<String,Object> blurredQuery(Map<String,Object> ctxmap){

        mytoolGetrBasedecl mytoolGetrBasedecl = myBeanUtils.mapToObject(ctxmap, mytoolGetrBasedecl.class);
        mytoolGetrBasedecl.setBelgprjt(currentproject);
        myPages mypages = myPages.getMyPagesFromMap(ctxmap);

        List<mytoolGetrBasedecl> resltlst = localjdbcOperate.selectListBySqlIdForPage(localjdbcOperate.NAME_SPACE+
                                                            "GetrBaseDeclFuzzQuery",mytoolGetrBasedecl,mypages);
        ctxmap.put(myBaseDeclare.resltlst,resltlst);
        ctxmap.put(myBaseDeclare.pagedata,mypages);
        return ctxmap;
    }

    public Map<String,Object> addWordBook(Map<String,Object> ctxmap){
        mytoolGetrBasedecl mytoolGetrBasedecl = myBeanUtils.mapToObject(ctxmap,mytoolGetrBasedecl.class);
        mytoolGetrBasedecl.setBelgprjt(currentproject);
        mytoolGetrBasedecl.setBelgmodl(currentmodle);
        localjdbcOperate.insert(mytoolGetrBasedecl);
        dynamicJdbcOperate.insert(mytoolGetrBasedecl);
        return ctxmap;
    }
}
