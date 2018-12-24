package org.ling.sms.common;

public class PatientInfo {

  private String phoneNum;

  private String patientName;

  private String hospital;

  private String check;

  private String date;

  private String department;

  public PatientInfo(String phoneNum, String patientName, String hospital, String check, String date, String department) {
    this.phoneNum = phoneNum;
    this.patientName = patientName;
    this.hospital = hospital;
    this.check = check;
    this.date = date;
    this.department = department;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getHospital() {
    return hospital;
  }

  public void setHospital(String hospital) {
    this.hospital = hospital;
  }

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String toTemplate() {
    StringBuilder builder = new StringBuilder();

    builder.append("{");
    builder.append("\"patientName\":").append("\"" + getPatientName() + "\",");
    builder.append("\"hospital\":").append("\"" + getHospital() + "\",");
    builder.append("\"check\":").append("\"" + getCheck() + "\",");
    builder.append("\"date\":").append("\"" + getDate() + "\",");
    builder.append("\"department\":").append("\"" + getDepartment() + "\"");
    builder.append("}");

    return builder.toString();
  }
}
