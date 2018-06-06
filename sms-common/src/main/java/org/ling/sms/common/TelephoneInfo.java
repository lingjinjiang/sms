package org.ling.sms.common;

public class TelephoneInfo {
  public TelephoneInfo(int phoneNum) {
    this.phoneNum = phoneNum;
  }


  public int getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(int phoneNum) {
    this.phoneNum = phoneNum;
  }

  int phoneNum;
}
