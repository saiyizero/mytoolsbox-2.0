package com.virugan.mytoolsbox.service;
import com.virugan.mytoolsbox.configuration.myContents;
import com.virugan.mytoolsbox.configuration.myContext;
import com.virugan.mytoolsbox.dao.localFileDao;
import com.virugan.mytoolsbox.entry.myFileEntry;
import com.virugan.mytoolsbox.entry.myflbatchNmelst;
import com.virugan.mytoolsbox.entry.myflbatchNmelstExample;
import com.virugan.mytoolsbox.mapper.myflbatchNmelstMapper;
import com.virugan.mytoolsbox.utils.myBeanUtils;
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
    myflbatchNmelstMapper myflbatchnmelstMapper;

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

    public List<myFileEntry> getBatchFileList(String staPath,String scanTyp){
        List<myFileEntry> myFileEntries = new ArrayList<myFileEntry>();
        myflbatchNmelstExample nmelstExample = new myflbatchNmelstExample();
        myflbatchNmelstExample.Criteria criteria = nmelstExample.createCriteria();
        criteria.andGropNameEqualTo("黑名单");
        List<myflbatchNmelst> blckLsit = myflbatchnmelstMapper.selectByExample(nmelstExample);
        Map<String, Object> blckMap = myBeanUtils.getMap();
        for(myflbatchNmelst myflbatchNme:blckLsit){
            blckMap.put(myflbatchNme.getSuffName(),"");
        }

        if(scanTyp.equals(myContents.MOVE)){
            myflbatchNmelstExample nmelstExample2 = new myflbatchNmelstExample();
            myflbatchNmelstExample.Criteria criteria2 = nmelstExample2.createCriteria();
            criteria2.andGropNameEqualTo("移动后缀");
            List<myflbatchNmelst> moveList = myflbatchnmelstMapper.selectByExample(nmelstExample2);
            Map<String, Object> movekMap = myBeanUtils.getMap();
            for(myflbatchNmelst myflbatchNme:moveList){
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

        }else if(scanTyp.equals(myContents.DELETE)){
            myflbatchNmelstExample nmelstExample2 = new myflbatchNmelstExample();
            myflbatchNmelstExample.Criteria criteria2 = nmelstExample2.createCriteria();
            criteria2.andGropNameEqualTo("删除后缀");
            List<myflbatchNmelst> deletList = myflbatchnmelstMapper.selectByExample(nmelstExample2);
            Map<String, Object> deletMap = myBeanUtils.getMap();
            for(myflbatchNmelst myflbatchNme:deletList){
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

    public void delSuffix(myflbatchNmelst myflbatchnmelst){
        String suffName = myflbatchnmelst.getSuffName();
        if(myflbatchnmelst.getGropType().equals(myContext.SUFFIX)){
            suffName=suffName.toUpperCase();
        }
        myflbatchnmelst.setSuffName(suffName);

        myflbatchNmelstExample nmelstExample = new myflbatchNmelstExample();
        myflbatchNmelstExample.Criteria criteria = nmelstExample.createCriteria();
        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            criteria.andGropTypeEqualTo(myflbatchnmelst.getGropType());
        }
        if(myflbatchnmelst.getSuffName()!=null&& !myflbatchnmelst.getSuffName().equals("")){
            criteria.andSuffNameEqualTo(myflbatchnmelst.getSuffName());
        }
        if(myflbatchnmelst.getGropName()!=null&& !myflbatchnmelst.getGropName().equals("")){
            criteria.andGropNameEqualTo(myflbatchnmelst.getGropName());
        }
        myflbatchnmelstMapper.deleteByExample(nmelstExample);
    }

    public List<myflbatchNmelst> findNmeList(myflbatchNmelst myflbatchnmelst){
        myflbatchNmelstExample nmelstExample = new myflbatchNmelstExample();
        myflbatchNmelstExample.Criteria criteria = nmelstExample.createCriteria();
        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            criteria.andGropTypeEqualTo(myflbatchnmelst.getGropType());
        }
        List<myflbatchNmelst> myflbatchNmelsts = myflbatchnmelstMapper.selectByExample(nmelstExample);
        return myflbatchNmelsts;
    }

    public void addNmeList(myflbatchNmelst myflbatchnmelst){
        String suffName = myflbatchnmelst.getSuffName();
        if(myflbatchnmelst.getGropType().equals(myContext.SUFFIX)){
            suffName=suffName.toUpperCase();
        }
        myflbatchnmelst.setSuffName(suffName);

        myflbatchNmelstExample nmelstExample = new myflbatchNmelstExample();
        myflbatchNmelstExample.Criteria criteria = nmelstExample.createCriteria();
        if(myflbatchnmelst.getGropType()!=null&& !myflbatchnmelst.getGropType().equals("")){
            criteria.andGropTypeEqualTo(myflbatchnmelst.getGropType());
        }
        if(myflbatchnmelst.getSuffName()!=null&& !myflbatchnmelst.getSuffName().equals("")){
            criteria.andSuffNameEqualTo(myflbatchnmelst.getSuffName());
        }
        if(myflbatchnmelst.getGropName()!=null&& !myflbatchnmelst.getGropName().equals("")){
            criteria.andGropNameEqualTo(myflbatchnmelst.getGropName());
        }
        List<myflbatchNmelst> myflbatchNmelsts = myflbatchnmelstMapper.selectByExample(nmelstExample);
        if(myflbatchNmelsts.size()<=0){
            myflbatchnmelstMapper.insert(myflbatchnmelst);
        }

    }

    public List<myFileEntry> scanNmeList(String dirPath,String gropName,String scanType){
        Map<String, myFileEntry> map = new HashMap<String, myFileEntry>();
        List<myFileEntry> myFileEntries = new ArrayList<myFileEntry>();
        boolean bFileSize=false;
        boolean bFileSuff=false;
        if(scanType.equals(myContext.SUFFIX)){
            bFileSuff=true;
        }
        if(scanType.equals(myContext.NAME)){
            bFileSize=true;
        }

        myflbatchNmelstExample example = new myflbatchNmelstExample();
        myflbatchNmelstExample.Criteria criteria = example.createCriteria();
        criteria.andGropNameEqualTo(gropName);

        Map<String, Object> haveMap = new HashMap<String, Object>();
        List<myflbatchNmelst> myflbatchNmelsts = myflbatchnmelstMapper.selectByExample(example);
        for(myflbatchNmelst myflbatchNme:myflbatchNmelsts){
            haveMap.put(myflbatchNme.getSuffName(),"");
        }

        List<myFileEntry> list = localFileDao.scanFileList(dirPath, bFileSize, bFileSuff, false);
        for (myFileEntry myfileEntry:list){
            if(scanType.equals(myContext.SUFFIX)){
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
            }else if(scanType.equals(myContext.NAME)){
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
