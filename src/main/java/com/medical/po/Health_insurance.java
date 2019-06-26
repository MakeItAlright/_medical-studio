package com.medical.po;

public class Health_insurance {     //医保资料表
    private Integer hi_id;
    private String student_no;
    private String name;
    private String dept;
    private String grade;
    private String major;
    private String glass;
    private String card_no;
    private String id_no;
    private String mobile;
    private String start_date;
    private String end_date;
    private String hi_status;   //正常，作废

    public Integer getHi_id() {
        return hi_id;
    }

    public void setHi_id(Integer hi_id) {
        this.hi_id = hi_id;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getHi_status() {
        return hi_status;
    }

    public void setHi_status(String hi_status) {
        this.hi_status = hi_status;
    }
}
