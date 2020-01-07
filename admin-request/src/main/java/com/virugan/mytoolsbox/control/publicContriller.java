package com.virugan.mytoolsbox.control;

import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.dao.publicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.io.File;

@Controller
public class publicContriller {

    @Autowired
    publicDao publicdao;

    @RequestMapping(value="publicContriller.getLocalPath.action" ,method = {RequestMethod.POST },produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getLocalPath(String pageId){
        myContents.log("publicContriller.getLocalPath start ----");
        myContents.log(String.format("[%s]",pageId));

        JFileChooser jfc = new JFileChooser();
        jfc.setVisible(true);
        String pathByName = publicdao.getPathByName(pageId);
        if(pathByName!=null&&!pathByName.equals("")){
            jfc.setCurrentDirectory(new File(pathByName));
        }
        String path="";
        int state = jfc.showOpenDialog(null);
        if (state != 1) {
            File f = jfc.getSelectedFile();
            path= f.getAbsolutePath();
            publicdao.setPathByName(pageId,f.getParentFile().getAbsolutePath());
        }

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.FILEPATH,path);
        myContents.log("publicContriller.getLocalPath end ----");

        return mycontext.toJson();

    }

    @RequestMapping(value="publicContriller.getLocalPathForFolder.action" ,method = {RequestMethod.POST },produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getLocalPathForFolder(String pageId){
        myContents.log("publicContriller.getLocalPathForFolder start ----");
        myContents.log(String.format("[%s]",pageId));

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(1);
        String pathByName = publicdao.getPathByName(pageId);
        if(pathByName!=null&&!pathByName.equals("")){
            jfc.setCurrentDirectory(new File(pathByName));
        }
        String path="";
        int state = jfc.showOpenDialog(null);
        if (state != 1) {
            File f = jfc.getSelectedFile();
            path= f.getAbsolutePath();
            publicdao.setPathByName(pageId,f.getParentFile().getAbsolutePath());
        }

        myContext mycontext = myContext.getInstance();
        mycontext.put(myContext.FILEPATH,path);
        mycontext.put(myContext.NAME,pageId);
        myContents.log("publicContriller.getLocalPathForFolder end ----");

        return mycontext.toJson();

    }

}
