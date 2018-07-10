package org.ling.sms.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConfiguration {

  @Test
  public void testConfiguation() {
    SmsConfiguration conf = new SmsConfiguration();
    try {
      conf.init();
    } catch (ConfigurationException e) {
      System.out.print("aaaaa");
    }
    System.out.println(System.getProperty("java.class.path"));
    assertEquals("111", conf.getString("aaa"));
  }
}
