package org.ling.sms.web;

import java.util.List;

public class CheckItems {
  List<CheckItem> lisDetial;

  public List<CheckItem> getLisDetial() {
    return lisDetial;
  }

  public void setLisDetial(List<CheckItem> lisDetial) {
    this.lisDetial = lisDetial;
  }

  public static class CheckItem {
    private String type;
    private String name;
    private String result;
    private String unit;
    private String flag;
    private String range;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getResult() {
      return result;
    }

    public void setResult(String result) {
      this.result = result;
    }

    public String getUnit() {
      return unit;
    }

    public void setUnit(String unit) {
      this.unit = unit;
    }

    public String getFlag() {
      return flag;
    }

    public void setFlag(String flag) {
      this.flag = flag;
    }

    public String getRange() {
      return range;
    }

    public void setRange(String range) {
      this.range = range;
    }
  }
}
