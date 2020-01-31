package com.virugan.control;

import com.virugan.api.localDataCache;
import com.virugan.constant.myBaseDeclare;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.myUtlis.myJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.io.File;
import java.util.Map;

@Controller
public class publicContriller {

    @Autowired
    localDataCache localdatacache;

    @RequestMapping(value="publicContriller.getLocalPath.action" ,method = {RequestMethod.POST },produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getLocalPath(String pageId){

        JFileChooser jfc = new JFileChooser();
        jfc.setVisible(true);
        String pathByName = localdatacache.getPathByName(pageId);
        if(pathByName!=null&&!pathByName.equals("")){
            jfc.setCurrentDirectory(new File(pathByName));
        }
        String path="";
        int state = jfc.showOpenDialog(null);
        if (state != 1) {
            File f = jfc.getSelectedFile();
            path= f.getAbsolutePath();
            localdatacache.setPathByName(pageId,f.getParentFile().getAbsolutePath());
        }
        Map<String, Object> mycontext = myBeanUtils.getMap();

        return myJsonUtils.toJsonString(mycontext);

    }

    @RequestMapping(value="publicContriller.getLocalPathForFolder.action" ,method = {RequestMethod.POST },produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getLocalPathForFolder(String pageId){


        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(1);
        String pathByName = localdatacache.getPathByName(pageId);
        if(pathByName!=null&&!pathByName.equals("")){
            jfc.setCurrentDirectory(new File(pathByName));
        }
        String path="";
        int state = jfc.showOpenDialog(null);
        if (state != 1) {
            File f = jfc.getSelectedFile();
            path= f.getAbsolutePath();
            localdatacache.setPathByName(pageId,f.getParentFile().getAbsolutePath());
        }

        Map<String, Object> mycontext = myBeanUtils.getMap();
        mycontext.put(myBaseDeclare.filepath,path);
        mycontext.put(myBaseDeclare.htmlpage,pageId);

        return myJsonUtils.toJsonString(mycontext);

    }

}
