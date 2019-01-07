package org.ling.sms.common;

import com.google.gson.Gson;

import java.util.Map;

public class CommonMessage {
  String phoneNum;
  Map<String, String> content;

  public CommonMessage(String phoneNum, Map<String, String> content) {
    this.phoneNum = phoneNum;
    this.content = content;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Map<String, String> getContent() {
    return content;
  }

  public void setContent(Map<String, String> content) {
    this.content = content;
  }

  public String getContentAsJson() {
    Gson gson = new Gson();
    return gson.toJson(content);
  }
}
