package org.ling.sms.web.api;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.ling.sms.common.CommonMessage;
import org.ling.sms.datamanager.DataManager;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/sm")
public class ShortMessage {


  DataManager dataManager;

  @Inject
  public ShortMessage(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  @Path("/getCode/{id}")
  @GET
  public String getCode(@PathParam("id") String id) {
    if (dataManager != null) {
      return "hello " + dataManager.getCaptcha(15062255934L);
    }
    return "hello " + id + id;
  }

  @Path("/sendReportMessage")
  @POST
  public String sendReportMessage(String patientInfoJson) {
    Gson gson = new Gson();
    CommonMessage patient = gson.fromJson(patientInfoJson, CommonMessage.class);
    dataManager.sendReportMessage(patient.getPhoneNum(), patient.getContentAsJson());
    return patient.getPhoneNum() + "\n" + patient.getContent();
  }

}
