package org.ling.sms.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;

public class SmsConfiguration {
  private Configuration conf;

  public SmsConfiguration() {
  }

  public void init() throws ConfigurationException {
    this.conf = new PropertiesConfiguration(new File("./sms-site.ini"));

  }

  public String getString(String key) {
    return this.conf.getString(key);
  }

  public String getString(String key, String defaultValue) {
    return this.conf.getString(key, defaultValue);
  }
}
