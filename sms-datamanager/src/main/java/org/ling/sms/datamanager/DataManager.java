package org.ling.sms.datamanager;

public class DataManager {
  public int getCaptcha(String phoneNum) {
    int captcha = (int)(Math.random() * 10000);
    return captcha;
  }

  public String getReportList(String beginTime,String endTime){
    return "list";
  }

  public String getReport(String reportId){
    return "report";
  }
}
