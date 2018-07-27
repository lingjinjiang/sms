package org.ling.sms.web.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.apache.commons.configuration.Configuration;
import org.ling.sms.datamanager.DataManager;
import org.ling.sms.provider.common.Provider;

public class RestListener extends GuiceServletContextListener {

  Configuration conf;
  Provider provider;
  DataManager dataManager;

  public RestListener(Configuration conf, Provider provider, DataManager dataManager) {
    this.conf = conf;
    this.provider = provider;
    this.dataManager = dataManager;
  }

  protected Injector getInjector() {
    return Guice.createInjector(new RestModule(this.conf, this.provider, this.dataManager));
  }
}
