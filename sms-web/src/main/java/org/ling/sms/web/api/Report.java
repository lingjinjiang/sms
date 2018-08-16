package org.ling.sms.web.api;

import com.google.inject.Inject;
import org.ling.sms.datamanager.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;


@Path("/report")
public class Report {
  private static Logger LOG = LoggerFactory.getLogger(Report.class);

  DataManager dataManager;

  @Inject
  public Report(DataManager dataManager) {
    this.dataManager = dataManager;
  }


  @Path("/detail")
  @POST
  public String getReportDetail(String condition) {
    String result = "not result";
    try {
      result = dataManager.getReportDetail(condition);
    } catch (IOException e) {

    }
    return result;
  }

  @Path("/list")
  @POST
  @Produces(MediaType.APPLICATION_XML)
  public String getReportList(@Context HttpServletRequest req,
                              @Context HttpServletResponse res,
                              String condition) {

    HttpSession session = req.getSession();
    LOG.info("+++++++++ {}", session.getId());
    String result = "not result";
    try {
      result = dataManager.getReportList(condition);
    } catch (IOException e) {
      LOG.error("Query failed: ", e);
    }

    return result;
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
