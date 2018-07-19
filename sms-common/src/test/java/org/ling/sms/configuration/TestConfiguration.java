package org.ling.sms.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConfiguration {

  @Test
  public void testConfiguation() {

    Configuration conf;
    try {
      conf = new PropertiesConfiguration("sms-site.ini");
      assertEquals("111", conf.getString("aaa"));
    } catch (ConfigurationException e) {
      System.out.print("aaaaa");
    }
    System.out.println(System.getProperty("java.class.path"));
  }
}
