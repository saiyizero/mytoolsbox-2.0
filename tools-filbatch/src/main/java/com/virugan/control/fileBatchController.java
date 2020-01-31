package com.virugan.control;

import com.virugan.constant.myBaseDeclare;
import com.virugan.constant.myBaseEnume;
import com.virugan.dao.localFileDao;
import com.virugan.entry.myFileEntry;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.myUtlis.myJsonUtils;
import com.virugan.service.fileBatchServ;
import com.virugan.tables.mytoolFlbhNamelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class fileBatchController {

    @Autowired
    fileBatchServ filebatchServ;

    @RequestMapping(value="fileBatchController.batchDeleteFile.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String batchDeleteFile(String staPath){

        List<myFileEntry> nmeList = filebatchServ.getBatchFileList(staPath, myBaseEnume.E_BATHTYPE.DELETE);
        for (myFileEntry myFile:nmeList){
            filebatchServ.removeFile(myFile.getFilePath());
        }
        localFileDao.delNullFolder(new File(staPath));

        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.resltlst,nmeList);
        mycontext.put("staPath",staPath);

        return myJsonUtils.toJsonString(mycontext);
    }

    //查找批处理文件列表
    @RequestMapping(value="fileBatchController.batchMoveFile.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String batchMoveFile(String staPath,String endPath,String scanTyp){

        List<myFileEntry> nmeList = filebatchServ.getBatchFileList(staPath,myBeanUtils.toEnum(myBaseEnume.E_BATHTYPE.class,scanTyp));
        for (myFileEntry myFile:nmeList){
            filebatchServ.batchMoveFile(myFile.getFilePath(),endPath);
        }
        localFileDao.delNullFolder(new File(staPath));

        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.resltlst,nmeList);
        mycontext.put("staPath",staPath);
        mycontext.put("endPath",endPath);
        mycontext.put("scanTyp",scanTyp);

        return myJsonUtils.toJsonString(mycontext);
    }

    //查找名单列表
    @RequestMapping(value="fileBatchController.findNmeList.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findNmeList(mytoolFlbhNamelist myflbatchnmelst){

        List<mytoolFlbhNamelist> nmeList = filebatchServ.findNmeList(myflbatchnmelst);
        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.resltlst,nmeList);

        return myJsonUtils.toJsonString(mycontext);
    }

    //新增后缀
    @RequestMapping(value="fileBatchController.addNmeList.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addNmeList(mytoolFlbhNamelist myflbatchnmelst){

        filebatchServ.addNmeList(myflbatchnmelst);

        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.respcode,myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(mycontext);
    }

    //删除后缀
    @RequestMapping(value="fileBatchController.delSuffix.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delSuffix(mytoolFlbhNamelist myflbatchnmelst){

        filebatchServ.delSuffix(myflbatchnmelst);

        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.respcode,myBaseEnume.E_RESPCODE.SUCESS);

        return myJsonUtils.toJsonString(mycontext);
    }

    //扫描后缀
    @RequestMapping(value="fileBatchController.ScanNmeListForSuffix.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ScanNmeListForSuffix(String filpath,String gropName){

        List<myFileEntry> myFileEntries = filebatchServ.scanNmeList(filpath, gropName, myBaseEnume.E_FLHDTYPE.SUFFIX);
        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.resltlst,myFileEntries);


        return myJsonUtils.toJsonString(mycontext);
    }

    //扫描文件名
    @RequestMapping(value="fileBatchController.ScanNmeListForFileNme.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ScanNmeListForFileNme(String filpath){

        List<myFileEntry> myFileEntries = filebatchServ.scanNmeList(filpath,"黑名单",  myBaseEnume.E_FLHDTYPE.FILNME);
        Map mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.resltlst,myFileEntries);

        return myJsonUtils.toJsonString(mycontext);
    }
}
