package org.ling.sms.common;

public class TelephoneInfo {
  public TelephoneInfo(long phoneNum) {
    this.phoneNum = phoneNum;
  }


  public long getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(long phoneNum) {
    this.phoneNum = phoneNum;
  }

  long phoneNum;
}
