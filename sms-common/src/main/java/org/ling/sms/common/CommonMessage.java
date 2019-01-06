package org.ling.sms.common;

public class CommonMessage {
  String phoneNum;
  String content;

  public CommonMessage(String phoneNum, String content) {
    this.phoneNum = phoneNum;
    this.content = content;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
