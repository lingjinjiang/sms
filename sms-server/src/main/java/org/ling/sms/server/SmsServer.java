package org.ling.sms.server;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.ling.sms.common.AbstractService;
import org.ling.sms.datamanager.DataManager;
import org.ling.sms.provider.aliyun.AliyunProvider;
import org.ling.sms.provider.common.EmptyProvider;
import org.ling.sms.provider.common.Provider;
import org.ling.sms.web.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsServer extends AbstractService {
  private static final Logger LOG = LoggerFactory.getLogger(SmsServer.class);

  private DataManager datamanager;
  private Configuration conf;
  private RestService webApp;
  private Provider provider;

  public SmsServer() {
  }

  public void serviceInit() {
    try {

      this.conf = new PropertiesConfiguration("sms-site.ini");
    } catch (ConfigurationException e) {
      LOG.error("Can not initialize the configuration: ", e);
    }
    this.provider = new EmptyProvider();

    this.datamanager = new DataManager(this.conf, this.provider, "aaaaa");
    this.datamanager.init();


    this.webApp = new RestService(this.conf, this.provider, this.datamanager);
    webApp.init();
  }

  public void serviceStart() {
    LOG.info("Start data manager");
    datamanager.start();
    LOG.info("Start web server");
    webApp.start();
  }

  public static void main(String[] args) {
    SmsServer sms = new SmsServer();
    sms.init();
    sms.start();
  }

}
