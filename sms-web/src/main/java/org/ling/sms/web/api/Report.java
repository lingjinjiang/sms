package org.ling.sms.web.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

  @POST
  @Path("/setReport")
  public String setReport(String message) {
    return "hello " + message;
  }

  @POST
  @Path("/setJsonReport")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String setJsonReport(JsonReport report) {
    return report.getId() + " +==============+ " + report.getContent();
  }
}
