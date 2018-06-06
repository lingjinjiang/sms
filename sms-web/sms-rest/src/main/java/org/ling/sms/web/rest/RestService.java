package org.ling.sms.web.rest;

import org.ling.sms.datamanager.DataManager;
import org.ling.sms.common.TelephoneInfo;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
public class RestService {

  private DataManager dataManager;

  public RestService() {
    this.dataManager = new DataManager();
  }

  private static final Logger LOG = LoggerFactory.getLogger(RestService.class);

  private int verifyCode = -1;

  @RequestMapping(path = "/code", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public int code(HttpServletRequest request, HttpServletResponse response, @RequestBody TelephoneInfo phone) {
    response.setHeader("Access-Control-Allow-Origin", "*");
    LOG.info("+++++++++++++++ {}", phone.getPhoneNum());
    if (verifyCode == -1) {
      verifyCode = dataManager.getCaptcha(Integer.toString(phone.getPhoneNum()));
    }
    return verifyCode;

  }

  @RequestMapping(path = "/getReportList", method = RequestMethod.POST)
  public String getReportList(HttpServletRequest request, HttpServletResponse response, @RequestBody String message) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    return dataManager.getReportList("aaa", "bbb");
  }

  @RequestMapping(path = "/getReport", method = RequestMethod.POST)
  public String getReport(HttpServletRequest request, HttpServletResponse response, @RequestBody String message) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    return dataManager.getReport("aaa");
  }


  public static void main(String[] args) throws Exception {
    SpringApplication.run(RestService.class, args);
  }
}