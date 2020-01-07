package com.virugan.mytoolsbox.dao;

import com.virugan.mytoolsbox.entry.myFileEntry;
import com.virugan.mytoolsbox.utils.myDateUtils;
import com.virugan.mytoolsbox.utils.myFileUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class localFileDao {

    public static List<myFileEntry> scanFileList(String dirPath){
        return scanFileList(dirPath,false,false,false);
    }

    public static List<myFileEntry> scanFileList(String dirPath,boolean fileSize,boolean fileSuff,boolean opeiTime){
        List<myFileEntry> myFileEntryList = new ArrayList<myFileEntry>();
        File file = new File(dirPath);
        File files[] = file.listFiles();
        if(files == null){
            return myFileEntryList;
        }
        for (File f : files) {
            if(f.isDirectory()){
                List<myFileEntry> myFileEntries = scanFileList(f.getAbsolutePath(),fileSize,fileSuff,opeiTime);
                myFileEntryList.addAll(myFileEntries);
            } else if(f.isFile()){
                String FileName = f.getName();
                myFileEntry myfileEntry = new myFileEntry();
                myfileEntry.setFileName(FileName);
                myfileEntry.setFilePath(f.getPath());
                if(fileSize){
                    myfileEntry.setFileSize(myFileUtils.getFileSize(f));
                }
                if(fileSuff){
                    String suffix = FileName.substring(FileName.lastIndexOf(".") + 1);
                    myfileEntry.setFileSuff("."+suffix.toUpperCase());
                }
                if(fileSuff){
                    Long lastModified = file.lastModified();
                    Date date = new Date(lastModified);
                    myfileEntry.setOpeiTime(myDateUtils.format(date,"yyyy-MM-dd HH:mm:ss"));
                }
                myFileEntryList.add(myfileEntry);
            }

        }
        return myFileEntryList;
    }

    public static void delNullFolder(File folder) {

        if(!folder.exists()){
            System.out.println("文件源不存在");
            return ;
        }
        LinkedList<File> list = new LinkedList<File>();
        File file[] = folder.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()){
                list.add(file[i]);
            }
        }

        File tmp;
        while (!list.isEmpty()) {
            tmp =list.removeFirst();
            if (tmp.isDirectory()) {
                file=tmp.listFiles();
                int len = file.length;
                if (len == 0){
                    boolean f = tmp.delete();
                    System.out.println(tmp+" is delete"+f);
                    list.add(new File(tmp.getParent()));
                    continue;
                }
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory()){
                        list.add(file[i]);
                    }
                }
            }
        }
    }

}
