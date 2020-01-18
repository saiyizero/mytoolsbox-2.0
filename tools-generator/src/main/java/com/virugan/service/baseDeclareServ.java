package com.virugan.service;

import com.virugan.api.getrDynamicJdbcOperate;
import com.virugan.api.localJdbcOperate;
import com.virugan.component.myPages;
import com.virugan.constant.myBaseDeclare;
import com.virugan.tables.mytoolGetrBasedecl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.virugan.constant.myBaseDeclare.pagedata;
import static com.virugan.constant.myBaseDeclare.resltlst;

@Component
public class baseDeclareServ {

    @Value("${getr.currentproject}")
    private String currentproject;

    @Autowired
    getrDynamicJdbcOperate jdbcOperate;

    /*基础字典全量查询*/
    public Map<String,Object> fuzzyQuery(Map<String,Object> ctxmap){
        mytoolGetrBasedecl mytoolGetrBasedecl = new mytoolGetrBasedecl();
        mytoolGetrBasedecl.setBelgprjt(currentproject);
        myPages mypages = myPages.getMyPagesFromMap(ctxmap);
        List<mytoolGetrBasedecl> resltlst = jdbcOperate.selectListByInputForPage(mytoolGetrBasedecl, mypages);
        ctxmap.put(myBaseDeclare.resltlst,resltlst);
        ctxmap.put(myBaseDeclare.pagedata,mypages);
        return ctxmap;
    }
}
