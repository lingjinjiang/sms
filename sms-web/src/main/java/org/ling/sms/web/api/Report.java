package org.ling.sms.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/report")
public class Report {
  @Path("/getReportInfo")
  @GET
  public String getReportInfo() {
    return "report info";
  }

  @Path("/getReportList")
  @GET
  public String getReportList() {
    return "report list";
  }
}
