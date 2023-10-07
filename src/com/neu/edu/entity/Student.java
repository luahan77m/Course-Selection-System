package com.neu.edu.entity;
        import java.lang.Integer;

/**
* ClassName:Student
* Description: 学生实体类
*/
public class Student {


        private Integer id;

        private String username;

        private String password;

        private String sex;

        private String stnum;

        private String classinfo;

        private String department;

        private String tellphone;

        private String remark;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getUsername() {
        return username;
        }

        public void setUsername(String username) {
        this.username = username;
        }

        public String getPassword() {
        return password;
        }

        public void setPassword(String password) {
        this.password = password;
        }

        public String getSex() {
        return sex;
        }

        public void setSex(String sex) {
        this.sex = sex;
        }

        public String getStnum() {
        return stnum;
        }

        public void setStnum(String stnum) {
        this.stnum = stnum;
        }

        public String getClassinfo() {
        return classinfo;
        }

        public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
        }

        public String getDepartment() {
        return department;
        }

        public void setDepartment(String department) {
        this.department = department;
        }

        public String getTellphone() {
        return tellphone;
        }

        public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
        }

        public String getRemark() {
        return remark;
        }

        public void setRemark(String remark) {
        this.remark = remark;
        }


}