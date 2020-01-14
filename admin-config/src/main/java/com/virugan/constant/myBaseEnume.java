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
}
