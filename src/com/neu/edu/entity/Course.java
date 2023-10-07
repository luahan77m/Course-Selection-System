package com.neu.edu.entity;
        import java.lang.Integer;

/**
* ClassName:Course
* Description: 课程实体类
*/
public class Course {


        private Integer id;

        private String name;

        private String content;

        private String period;

        private String credit;

        private String stid;

        private String atid;

        private String classroom;

        private String timeinfo;

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private String remark;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public String getContent() {
        return content;
        }

        public void setContent(String content) {
        this.content = content;
        }

        public String getPeriod() {
        return period;
        }

        public void setPeriod(String period) {
        this.period = period;
        }

        public String getCredit() {
        return credit;
        }

        public void setCredit(String credit) {
        this.credit = credit;
        }

        public String getStid() {
        return stid;
        }

        public void setStid(String stid) {
        this.stid = stid;
        }

        public String getAtid() {
        return atid;
        }

        public void setAtid(String atid) {
        this.atid = atid;
        }

        public String getClassroom() {
        return classroom;
        }

        public void setClassroom(String classroom) {
        this.classroom = classroom;
        }

        public String getTimeinfo() {
        return timeinfo;
        }

        public void setTimeinfo(String timeinfo) {
        this.timeinfo = timeinfo;
        }

        public String getRemark() {
        return remark;
        }

        public void setRemark(String remark) {
        this.remark = remark;
        }


}