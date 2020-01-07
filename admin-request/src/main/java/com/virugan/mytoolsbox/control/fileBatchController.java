package com.virugan.mytoolsbox.control;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.dao.localFileDao;
import com.virugan.mytoolsbox.entry.myFileEntry;
import com.virugan.mytoolsbox.entry.myflbatchNmelst;
import com.virugan.mytoolsbox.service.fileBatchServ;
import com.virugan.mytoolsbox.utils.myBeanUtils;
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

        myContents.log("fileBatchController.batchDeleteFile start ----");
        myContents.log(String.format("staPath [%s]", staPath));

        List<myFileEntry> nmeList = filebatchServ.getBatchFileList(staPath,myContents.DELETE);
        for (myFileEntry myFile:nmeList){
            filebatchServ.removeFile(myFile.getFilePath());
        }
        localFileDao.delNullFolder(new File(staPath));

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,nmeList);
        mycontext.put("staPath",staPath);
        myContents.log(String.format("mycontext [%s]", mycontext.toJson()));
        myContents.log("fileBatchController.batchDeleteFile end ----");
        return mycontext.toJson();
    }

    //查找批处理文件列表
    @RequestMapping(value="fileBatchController.batchMoveFile.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String batchMoveFile(String staPath,String endPath,String scanTyp){

        myContents.log("fileBatchController.batchMoveFile start ----");
        myContents.log(String.format("staPath [%s]， endPath [%s]， scanTyp [%s]", staPath,endPath,scanTyp));

        List<myFileEntry> nmeList = filebatchServ.getBatchFileList(staPath,scanTyp);
        for (myFileEntry myFile:nmeList){
            filebatchServ.batchMoveFile(myFile.getFilePath(),endPath);
        }
        localFileDao.delNullFolder(new File(staPath));

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,nmeList);
        mycontext.put("staPath",staPath);
        mycontext.put("endPath",endPath);
        mycontext.put("scanTyp",scanTyp);
        myContents.log(String.format("mycontext [%s]", mycontext.toJson()));
        myContents.log("fileBatchController.batchMoveFile end ----");
        return mycontext.toJson();
    }

    //查找名单列表
    @RequestMapping(value="fileBatchController.findNmeList.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findNmeList(myflbatchNmelst myflbatchnmelst){
        myContents.log("fileBatchController.findNmeList start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(myflbatchnmelst)));

        List<myflbatchNmelst> nmeList = filebatchServ.findNmeList(myflbatchnmelst);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,nmeList);
        myContents.log("fileBatchController.findNmeList end ----");
        return mycontext.toJson();
    }

    //新增后缀
    @RequestMapping(value="fileBatchController.addNmeList.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addNmeList(myflbatchNmelst myflbatchnmelst){
        myContents.log("fileBatchController.addNmeList start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(myflbatchnmelst)));

        filebatchServ.addNmeList(myflbatchnmelst);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("fileBatchController.addNmeList end ----");
        return mycontext.toJson();
    }

    //删除后缀
    @RequestMapping(value="fileBatchController.delSuffix.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delSuffix(myflbatchNmelst myflbatchnmelst){
        myContents.log("fileBatchController.delSuffix start ----");
        myContents.log(String.format("[%s]", myBeanUtils.objectToMap(myflbatchnmelst)));

        filebatchServ.delSuffix(myflbatchnmelst);

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.RESULT,myContents.SUCCESS);
        myContents.log("fileBatchController.delSuffix end ----");
        return mycontext.toJson();
    }

    //扫描后缀
    @RequestMapping(value="fileBatchController.ScanNmeListForSuffix.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ScanNmeListForSuffix(String filpath,String gropName){
        myContents.log("fileBatchController.ScanNmeListForSuffix start ----");
        myContents.log(String.format("filpath[%s] ,gropName[%s]", filpath,gropName));

        List<myFileEntry> myFileEntries = filebatchServ.scanNmeList(filpath, gropName,myContext.SUFFIX);
        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,myFileEntries);


        myContents.log(String.format("[%s]", mycontext.toJson()));
        myContents.log("fileBatchController.ScanNmeListForSuffix end ----");
        return mycontext.toJson();
    }

    //扫描文件名
    @RequestMapping(value="fileBatchController.ScanNmeListForFileNme.action" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ScanNmeListForFileNme(String filpath){
        myContents.log("fileBatchController.ScanNmeListForFileNme start ----");
        myContents.log(String.format("filpath [%s]", filpath));

        List<myFileEntry> myFileEntries = filebatchServ.scanNmeList(filpath,"黑名单", myContext.NAME);
        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.MYLIST,myFileEntries);


        myContents.log(String.format("[%s]", mycontext.toJson()));
        myContents.log("fileBatchController.ScanNmeListForFileNme end ----");
        return mycontext.toJson();
    }
}
