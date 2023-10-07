package com.neu.edu.entity;

/**
* ClassName:Applyinfo
* Description: 课程申请实体类
*/
public class Applyinfo {


        private Integer id;

        private String sid;

        private String cid;

        private String content;

        private String prove;

        private String status;

        private String ctime;

        private String stid;

        private String stname;

        private String streason;

        private String atid;

        private String atname;
    /**
    * 主管教师理由
    */
        private String atreason;
    /**
    * 备注
    */
        private String remark;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getSid() {
        return sid;
        }

        public void setSid(String sid) {
        this.sid = sid;
        }

        public String getCid() {
        return cid;
        }

        public void setCid(String cid) {
        this.cid = cid;
        }

        public String getContent() {
        return content;
        }

        public void setContent(String content) {
        this.content = content;
        }

        public String getProve() {
        return prove;
        }

        public void setProve(String prove) {
        this.prove = prove;
        }

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }

        public String getCtime() {
        return ctime;
        }

        public void setCtime(String ctime) {
        this.ctime = ctime;
        }

        public String getStid() {
        return stid;
        }

        public void setStid(String stid) {
        this.stid = stid;
        }

        public String getStname() {
        return stname;
        }

        public void setStname(String stname) {
        this.stname = stname;
        }

        public String getStreason() {
        return streason;
        }

        public void setStreason(String streason) {
        this.streason = streason;
        }

        public String getAtid() {
        return atid;
        }

        public void setAtid(String atid) {
        this.atid = atid;
        }

        public String getAtname() {
        return atname;
        }

        public void setAtname(String atname) {
        this.atname = atname;
        }

        public String getAtreason() {
        return atreason;
        }

        public void setAtreason(String atreason) {
        this.atreason = atreason;
        }

        public String getRemark() {
        return remark;
        }

        public void setRemark(String remark) {
        this.remark = remark;
        }


}