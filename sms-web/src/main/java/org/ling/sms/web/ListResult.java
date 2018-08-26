package org.ling.sms.web;

import java.util.List;

public class ListResult {

  List<ReportInfo> lisInfo;

  public ListResult(List lisInfo) {
    this.lisInfo = lisInfo;
  }

  public List getLisInfo() {
    return lisInfo;
  }

  public void setLisInfo(List lisInfo) {
    this.lisInfo = lisInfo;
  }

  public static class ReportInfo {
    String checkDate;
    String item;
    String type;
    String clinicCode;

    public String getCheckDate() {
      return checkDate;
    }

    public void setCheckDate(String checkDate) {
      this.checkDate = checkDate;
    }

    public String getItem() {
      return item;
    }

    public void setItem(String item) {
      this.item = item;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getClinicCode() {
      return clinicCode;
    }

    public void setClinicCode(String clinicCode) {
      this.clinicCode = clinicCode;
    }

  }
}
