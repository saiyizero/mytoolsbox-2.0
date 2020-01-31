package com.virugan.service;

import com.virugan.api.localJdbcOperate;
import com.virugan.constant.myBaseEnume;
import com.virugan.dao.localFileDao;
import com.virugan.entry.myFileEntry;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.tables.mytoolFlbhNamelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class fileBatchServ {

    @Autowired
    localJdbcOperate jdbcoperate;

    public void removeFile(String staPath){
        File startFile = new File(staPath);
        System.out.println("remove file :"+ staPath );
        startFile.delete();
    }

    public void batchMoveFile(String staPath,String endPath){
        File startFile = new File(staPath);
        if(!new File(endPath).exists()){
            new File(endPath).mkdirs();
        }
        endPath=endPath+"\\"+startFile.getName();

        System.out.println("move file :"+ staPath +" to "+endPath);
        startFile.renameTo(new File(endPath));
    }

    public List<myFileEntry> getBatchFileList(String staPath,myBaseEnume.E_BATHTYPE scanTyp){
        List<myFileEntry> myFileEntries = new ArrayList<myFileEntry>();
        mytoolFlbhNamelist nmelstExample = new mytoolFlbhNamelist();
        nmelstExample.setGropName("黑名单");

        List<mytoolFlbhNamelist> blckLsit = jdbcoperate.selectListByInput(nmelstExample);
        Map<String, Object> blckMap = myBeanUtils.getMap();
        for(mytoolFlbhNamelist myflbatchNme:blckLsit){
            blckMap.put(myflbatchNme.getSuffName(),"");
        }

        if(scanTyp.equals(myBaseEnume.E_BATHTYPE.REMOVE)){
            mytoolFlbhNamelist inFlbhNamelist = new mytoolFlbhNamelist();
            inFlbhNamelist.setGropName("移动后缀");
            List<mytoolFlbhNamelist> moveList = jdbcoperate.selectListByInput(inFlbhNamelist);
            Map<String, Object> movekMap = myBeanUtils.getMap();
            for(mytoolFlbhNamelist myflbatchNme:moveList){
                movekMap.put(myflbatchNme.getSuffName(),"");
            }

            List<myFileEntry> list = localFileDao.scanFileList(staPath, false, true, false);
            for(myFileEntry myFile:list){
                if(blckMap.containsKey(myFile.getFileName())){
                    continue;
                }
                if(movekMap.containsKey(myFile.getFileSuff().toUpperCase())){
                    myFileEntries.add(myFile);
                }
            }

        }else if(scanTyp.equals(myBaseEnume.E_BATHTYPE.DELETE)){
            mytoolFlbhNamelist inFlbhNamelist = new mytoolFlbhNamelist();
            inFlbhNamelist.setGropName("删除后缀");
            List<mytoolFlbhNamelist> deletList = jdbcoperate.selectListByInput(inFlbhNamelist);
            Map<String, Object> deletMap = myBeanUtils.getMap();
            for(mytoolFlbhNamelist myflbatchNme:deletList){
                deletMap.put(myflbatchNme.getSuffName(),"");
            }

            List<myFileEntry> list = localFileDao.scanFileList(staPath, false, true, false);
            for(myFileEntry myFile:list){
                if(blckMap.containsKey(myFile.getFileName())){
                    myFileEntries.add(myFile);
                }
                if(deletMap.containsKey(myFile.getFileSuff().toUpperCase())){
                    myFileEntries.add(myFile);
                }
            }
        }
        return myFileEntries;
    }

    public void delSuffix(mytoolFlbhNamelist myflbatchnmelst){
        String suffName = myflbatchnmelst.getSuffName();
        if(myflbatchnmelst.getGropType().equals(myBaseEnume.E_FLHDTYPE.SUFFIX)){
            suffName=suffName.toUpperCase();
        }
        myflbatchnmelst.setSuffName(suffName);

        mytoolFlbhNamelist inFlbhNamelist = new mytoolFlbhNamelist();

        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            inFlbhNamelist.setGropType(myflbatchnmelst.getGropType());
        }
        if(myflbatchnmelst.getSuffName()!=null&& !myflbatchnmelst.getSuffName().equals("")){
            inFlbhNamelist.setSuffName(myflbatchnmelst.getSuffName());
        }
        if(myflbatchnmelst.getGropName()!=null&& !myflbatchnmelst.getGropName().equals("")){
            inFlbhNamelist.setGropName(myflbatchnmelst.getGropName());
        }
        jdbcoperate.deleteByPrimaryKey(inFlbhNamelist);
    }

    public List<mytoolFlbhNamelist> findNmeList(mytoolFlbhNamelist myflbatchnmelst){
        mytoolFlbhNamelist nmelstExample = new mytoolFlbhNamelist();

        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            nmelstExample.setGropType(myflbatchnmelst.getGropType());
        }

        List<mytoolFlbhNamelist> myflbatchNmelsts = jdbcoperate.selectListByInput(nmelstExample);
        return myflbatchNmelsts;
    }

    public void addNmeList(mytoolFlbhNamelist myflbatchnmelst){
        String suffName = myflbatchnmelst.getSuffName();
        if(myflbatchnmelst.getGropType().equals(myBaseEnume.E_FLHDTYPE.SUFFIX)){
            suffName=suffName.toUpperCase();
        }
        myflbatchnmelst.setSuffName(suffName);

        mytoolFlbhNamelist inFlbhNamelist = new mytoolFlbhNamelist();

        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            inFlbhNamelist.setGropType(myflbatchnmelst.getGropType());
        }
        if(myflbatchnmelst.getSuffName()!=null&& !myflbatchnmelst.getSuffName().equals("")){
            inFlbhNamelist.setSuffName(myflbatchnmelst.getSuffName());
        }
        if(myflbatchnmelst.getGropName()!=null&& !myflbatchnmelst.getGropName().equals("")){
            inFlbhNamelist.setGropName(myflbatchnmelst.getGropName());
        }
        List<mytoolFlbhNamelist> myflbatchNmelsts = jdbcoperate.selectListByInput(inFlbhNamelist);
        if(myflbatchNmelsts.size()<=0){
            jdbcoperate.insert(myflbatchnmelst);
        }

    }

    public List<myFileEntry> scanNmeList(String dirPath, String gropName, myBaseEnume.E_FLHDTYPE scanType){
        Map<String, myFileEntry> map = new HashMap<String, myFileEntry>();
        List<myFileEntry> myFileEntries = new ArrayList<myFileEntry>();
        boolean bFileSize=false;
        boolean bFileSuff=false;
        if(scanType.equals(myBaseEnume.E_FLHDTYPE.SUFFIX)){
            bFileSuff=true;
        }
        if(scanType.equals(myBaseEnume.E_FLHDTYPE.FILNME)){
            bFileSize=true;
        }

        mytoolFlbhNamelist example = new mytoolFlbhNamelist();
        example.setGropName(gropName);

        Map<String, Object> haveMap = new HashMap<String, Object>();
        List<mytoolFlbhNamelist> myflbatchNmelsts = jdbcoperate.selectListByInput(example);
        for(mytoolFlbhNamelist myflbatchNme:myflbatchNmelsts){
            haveMap.put(myflbatchNme.getSuffName(),"");
        }

        List<myFileEntry> list = localFileDao.scanFileList(dirPath, bFileSize, bFileSuff, false);
        for (myFileEntry myfileEntry:list){
            if(scanType.equals(myBaseEnume.E_FLHDTYPE.SUFFIX)){
                String key = myfileEntry.getFileSuff();
                if(map.containsKey(key)){
                    myFileEntry saveFileEntry = map.get(key);
                    Integer num=saveFileEntry.getFileNumb()+1;
                    saveFileEntry.setFileNumb(num);
                    map.put(key,saveFileEntry);
                }else {
                    myfileEntry.setFileName(null);
                    myfileEntry.setFilePath(null);
                    myfileEntry.setFileNumb(1);
                    map.put(key,myfileEntry);
                }
            }else if(scanType.equals(myBaseEnume.E_FLHDTYPE.FILNME)){
                String key = myfileEntry.getFileName();
                if(map.containsKey(key)){
                    myFileEntry saveFileEntry = map.get(key);
                    Integer num=saveFileEntry.getFileNumb()+1;
                    String fileSize = saveFileEntry.getFileSize();
                    if(!fileSize.equals(myfileEntry.getFileSize())){
                        fileSize=fileSize+" 、 "+myfileEntry.getFileSize();
                        saveFileEntry.setFileSize(fileSize);
                    }
                    saveFileEntry.setFileNumb(num);
                    map.put(key,saveFileEntry);
                }else {
                    myfileEntry.setFilePath(null);
                    myfileEntry.setFileNumb(1);
                    map.put(key,myfileEntry);
                }
            }
        }
        for (String key:map.keySet()){
            if(!haveMap.containsKey(key)){
                myFileEntries.add(map.get(key));
            }
        }
        return myFileEntries;
    }

}
