package org.ling.sms.datamanager;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.configuration.Configuration;
import org.ling.sms.common.AbstractService;
import org.ling.sms.provider.aliyun.AliyunProvider;
import org.ling.sms.provider.common.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataManager extends AbstractService {

  private static final Logger LOG = LoggerFactory.getLogger(DataManager.class);

  private enum CAPTCHA {A, B, C,}

  private Provider provider;

  private String name;

  private Configuration conf;

  private static DataManager dataManager;

  public DataManager(Configuration conf, Provider provider, String name) {
    this.conf = conf;
    this.provider = provider;
    this.name = name;
  }


  public String getName() {
    return name;
  }

  @Override
  public void serviceStart() {

  }

  @Override
  public void serviceInit() {
//    provider.serviceInit();
  }


  public int getCaptcha(long phoneNum) {
    int captcha = (int) (Math.random() * 10000);
    SendSmsResponse response;
//    try {
//      response = provider.sendMessage(Long.toString(phoneNum), Integer.toString(captcha));
//      LOG.info("++++++++++++ {}", response.getCode());
//    } catch (ClientException e) {
//      LOG.info("Failed to send message:", e);
//    }
    return captcha;
  }

  public String getReportList(String beginTime, String endTime) {
    return "list";
  }

  public String getReport(String reportId) {
    return "report";
  }
}
