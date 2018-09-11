package org.ling.sms.web;

import java.util.List;

public class UserInfos {

  List<User> userInfo;

  public List<User> getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(List<User> userInfo) {
    this.userInfo = userInfo;
  }

  public static class User {
    private String name;
    private String id;
    private String patientName;
    private String patientNo;
    private String label;
    private String sex;
    private String deptName;
    private String chekDate;
    private String age;
    private String bedNo;
    private String doctor;
    private String getLabelDate;
    private String reportDate;
    private String trier;
    private String assurance;
    private String mobile;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getPatientName() {
      return patientName;
    }

    public void setPatientName(String patientName) {
      this.patientName = patientName;
    }

    public String getPatientNo() {
      return patientNo;
    }

    public void setPatientNo(String patientNo) {
      this.patientNo = patientNo;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }

    public String getDeptName() {
      return deptName;
    }

    public void setDeptName(String deptName) {
      this.deptName = deptName;
    }

    public String getChekDate() {
      return chekDate;
    }

    public void setChekDate(String chekDate) {
      this.chekDate = chekDate;
    }

    public String getAge() {
      return age;
    }

    public void setAge(String age) {
      this.age = age;
    }

    public String getBedNo() {
      return bedNo;
    }

    public void setBedNo(String bedNo) {
      this.bedNo = bedNo;
    }

    public String getDoctor() {
      return doctor;
    }

    public void setDoctor(String doctor) {
      this.doctor = doctor;
    }

    public String getGetLabelDate() {
      return getLabelDate;
    }

    public void setGetLabelDate(String getLabelDate) {
      this.getLabelDate = getLabelDate;
    }

    public String getReportDate() {
      return reportDate;
    }

    public void setReportDate(String reportDate) {
      this.reportDate = reportDate;
    }

    public String getTrier() {
      return trier;
    }

    public void setTrier(String trier) {
      this.trier = trier;
    }

    public String getAssurance() {
      return assurance;
    }

    public void setAssurance(String assurance) {
      this.assurance = assurance;
    }

    public String getMobile() {
      return mobile;
    }

    public void setMobile(String mobile) {
      this.mobile = mobile;
    }
  }

}
