package org.ling.sms.web.module;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.container.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.util.FeaturesAndProperties;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.apache.commons.configuration.Configuration;
import org.ling.sms.datamanager.DataManager;
import org.ling.sms.provider.common.Provider;
import org.ling.sms.web.api.Report;
import org.ling.sms.web.api.ShortMessage;

import javax.servlet.ServletConfig;
import java.util.HashMap;
import java.util.Map;

public class RestModule extends ServletModule {

  private DataManager dataManager;
  private Provider provider;
  private Configuration conf;


  public RestModule(Configuration conf, Provider provider, DataManager dataManager) {
    this.conf = conf;
    this.provider = provider;
    this.dataManager = dataManager;
  }

  @Override
  protected void configureServlets() {
    bind(Report.class);
    bind(ShortMessage.class);
    bind(Configuration.class).toInstance(this.conf);
    bind(Provider.class).toInstance(provider);
    bind(DataManager.class).toInstance(dataManager);

    Map<String, String> params = new HashMap<String, String>();
    params.put(ResourceConfig.FEATURE_IMPLICIT_VIEWABLES, "true");
    params.put(ServletContainer.FEATURE_FILTER_FORWARD_ON_404, "true");
    params.put(FeaturesAndProperties.FEATURE_XMLROOTELEMENT_PROCESSING, "true");
    params.put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, GZIPContentEncodingFilter.class.getName());
    params.put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, GZIPContentEncodingFilter.class.getName());
    filter("/*").through(GuiceContainer.class, params);
  }
}
