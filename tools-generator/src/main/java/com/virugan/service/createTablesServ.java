package com.virugan.service;

import com.virugan.api.getrDynamicJdbcOperate;
import com.virugan.constant.myBaseDeclare;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.tables.mytoolGetrTabregtr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class createTablesServ {

    @Autowired
    getrDynamicJdbcOperate dynamicJdbcOperate;

    @Value("${getr.currentproject}")
    private String currentproject;
    @Value("${getr.currentmodle}")
    private String currentmodle;

    /*登陆时载入表结构*/
    public Map<String,Object> queryTables(Map<String,Object> ctxmap){

        mytoolGetrTabregtr inGetrTabcsant = myBeanUtils.mapToObject(ctxmap, mytoolGetrTabregtr.class);
        inGetrTabcsant.setBelgprjt(currentproject);
        inGetrTabcsant.setBelgmodl(currentmodle);
        List<mytoolGetrTabregtr> outGetrTabcsant = dynamicJdbcOperate.selectListByInput(inGetrTabcsant);

        int k=1;
        Map<String, Object> map=null;
        List<Map<String, Object>> resltlst = myBeanUtils.getListMap();
        for(mytoolGetrTabregtr tabcsant:outGetrTabcsant){
            if(k==1){
                map=myBeanUtils.getMap();
                map.put("tablnam1",tabcsant.getTablname());
                map.put("tablcom1",tabcsant.getTablcomt());
            }else if(k==2){
                map.put("tablnam2",tabcsant.getTablname());
                map.put("tablcom2",tabcsant.getTablcomt());
            }else if(k==3){
                map.put("tablnam3",tabcsant.getTablname());
                map.put("tablcom3",tabcsant.getTablcomt());
            }else if(k==4){
                map.put("tablnam4",tabcsant.getTablname());
                map.put("tablcom4",tabcsant.getTablcomt());
                resltlst.add(map);
                k=0;
            }
            k=k+1;
        }

        if(k!=1){
            resltlst.add(map);
        }

        ctxmap.put(myBaseDeclare.resltlst,resltlst);

        return ctxmap;
    }}
