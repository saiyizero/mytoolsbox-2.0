package com.virugan.service;

import com.virugan.api.localJdbcOperate;
import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.tables.mytoolGetrPrjtpara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class projectParamServ {
    @Autowired
    localJdbcOperate localjdbcOperate;
    @Value("${getr.currentproject}")
    private String currentproject;
    @Value("${getr.currentmodle}")
    private String currentmodle;

    /*新增项目*/
    public Map<String,Object> createProject(Map<String,Object> ctxmap){
        mytoolGetrPrjtpara inGetrPrjtpara = myBeanUtils.mapToObject(ctxmap, mytoolGetrPrjtpara.class);
        localjdbcOperate.insert(inGetrPrjtpara);
        return ctxmap;
    }

    /*修改项目配置*/
    public Map<String,Object> updateProject(Map<String,Object> ctxmap){
        mytoolGetrPrjtpara inGetrPrjtpara = myBeanUtils.mapToObject(ctxmap, mytoolGetrPrjtpara.class);
        localjdbcOperate.updateByPrimaryKey(inGetrPrjtpara);
        return ctxmap;
    }

    /*删除项目配置并清理项目数据*/
    public Map<String,Object> clearProject(Map<String,Object> ctxmap){
        mytoolGetrPrjtpara inGetrPrjtpara = myBeanUtils.mapToObject(ctxmap, mytoolGetrPrjtpara.class);
        localjdbcOperate.deleteByPrimaryKey(inGetrPrjtpara);
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);
        return ctxmap;
    }

    /*查询项目信息*/
    public Map<String,Object> queryProjectMsg(Map<String,Object> ctxmap){
        mytoolGetrPrjtpara inGetrprjtpara = new mytoolGetrPrjtpara();
        List<String> prjtlist = myBeanUtils.getList(String.class);
        List<String> modllist = myBeanUtils.getList(String.class);
        //查询项目列表
        List<mytoolGetrPrjtpara> list = localjdbcOperate.selectListByInput(inGetrprjtpara);
        String thisprjt="";
        for(mytoolGetrPrjtpara outGetrPrjtpara:list){

            if(!thisprjt.equals(outGetrPrjtpara.getBelgprjt())){
                prjtlist.add(outGetrPrjtpara.getBelgprjt());
                thisprjt=outGetrPrjtpara.getBelgprjt();
            }

            if(currentproject.equals(outGetrPrjtpara.getBelgprjt())){
                modllist.add(outGetrPrjtpara.getBelgmodl());
            }

            if(currentproject.equals(outGetrPrjtpara.getBelgprjt()) &&
               currentmodle.equals(outGetrPrjtpara.getBelgmodl())){
                ctxmap.putAll(myBeanUtils.objectToMap(outGetrPrjtpara));
            }
        }
        ctxmap.put(myBaseDeclare.prjtlist,prjtlist);
        ctxmap.put(myBaseDeclare.modllist,modllist);

        return ctxmap;
    }

    /*查询项目列表*/
    public Map<String,Object> queryProjectList(Map<String,Object> ctxmap){
        ctxmap.put(myBaseDeclare.respcode, myBaseEnume.E_RESPCODE.SUCESS);


        return ctxmap;
    }

}
