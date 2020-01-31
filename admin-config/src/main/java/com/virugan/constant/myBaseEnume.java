package com.virugan.constant;

public class myBaseEnume {

    /*响应码*/
    public static enum E_RESPCODE {
        /*成功*/
        SUCESS("SUCESS","sucess","成功"),
        /*失败*/
        FAILUR("FAILUR","failur","失败");

        private String id;
        private String vaule;
        private String comment;

        private E_RESPCODE(String id,String vaule,String comment){
            this.id=id;
            this.vaule=vaule;
            this.comment=comment;
        }

        public String getId(){
            return this.id;
        }
        public String getVaule(){
            return this.vaule;
        }
        public String getComment(){
            return this.comment;
        }
    }

    /*批处理方式*/
    public static enum E_BATHTYPE {
        /*删除*/
        DELETE("DELETE","delete","删除"),
        /*移动*/
        REMOVE("REMOVE","REMOVE","移动"),
        /*查询*/
        SELECT("SELECT","SELECT","查询"),
        /*添加*/
        INSERT("INSERT","insert","添加");

        private String id;
        private String vaule;
        private String comment;

        private E_BATHTYPE(String id,String vaule,String comment){
            this.id=id;
            this.vaule=vaule;
            this.comment=comment;
        }

        public String getId(){
            return this.id;
        }
        public String getVaule(){
            return this.vaule;
        }
        public String getComment(){
            return this.comment;
        }
    }

    /*文件处理类型*/
    public static enum E_FLHDTYPE {
        /*后缀*/
        SUFFIX("SUFFIX","suffix","后缀"),
        /*文件名*/
        FILNME("FILNME","filnme","文件名");

        private String id;
        private String vaule;
        private String comment;

        private E_FLHDTYPE(String id,String vaule,String comment){
            this.id=id;
            this.vaule=vaule;
            this.comment=comment;
        }

        public String getId(){
            return this.id;
        }
        public String getVaule(){
            return this.vaule;
        }
        public String getComment(){
            return this.comment;
        }
    }

    /*本地缓存类型*/
    public static enum E_CACHTYPE {
        /*文件路径*/
        FILEPATH("FILEPATH","filepath","文件路径"),
        /*文件名*/
        SEQUENCE("SEQUENCE","sequence","序列号");

        private String id;
        private String vaule;
        private String comment;

        private E_CACHTYPE(String id,String vaule,String comment){
            this.id=id;
            this.vaule=vaule;
            this.comment=comment;
        }

        public String getId(){
            return this.id;
        }
        public String getVaule(){
            return this.vaule;
        }
        public String getComment(){
            return this.comment;
        }
    }
}
