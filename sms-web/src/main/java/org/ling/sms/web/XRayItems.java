package org.ling.sms.web;

import java.util.List;

public class XRayItems {
  private List<XRayItem> pacsDetial;

  public List<XRayItem> getPacsDetial() {
    return pacsDetial;
  }

  public void setPacsDetial(List<XRayItem> pacsDetial) {
    this.pacsDetial = pacsDetial;
  }

  public static class XRayItem {
    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getResult() {
      return result;
    }

    public void setResult(String result) {
      this.result = result;
    }

    public String getScript() {
      return script;
    }

    public void setScript(String script) {
      this.script = script;
    }

    public String getTrier() {
      return trier;
    }

    public void setTrier(String trier) {
      this.trier = trier;
    }

    public String getReportDate() {
      return reportDate;
    }

    public void setReportDate(String reportDate) {
      this.reportDate = reportDate;
    }

    String type;
    String result;
    String script;
    String trier;
    String reportDate;
  }
}
