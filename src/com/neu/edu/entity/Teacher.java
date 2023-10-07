package com.neu.edu.entity;
        import java.lang.Integer;

/**
* ClassName:Teacher
* Description: 教师实体类
*/
public class Teacher {


        private Integer id;

        private String username;

        private String password;

        private String email;

        private String role;

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

        public String getEmail() {
        return email;
        }

        public void setEmail(String email) {
        this.email = email;
        }

        public String getRole() {
        return role;
        }

        public void setRole(String role) {
        this.role = role;
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