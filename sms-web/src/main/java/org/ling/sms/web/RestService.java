package org.ling.sms.web;

import com.google.inject.servlet.GuiceFilter;
import org.apache.commons.configuration.Configuration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.ling.sms.common.AbstractService;
import org.ling.sms.configuration.ConfigConstant;
import org.ling.sms.datamanager.DataManager;
import org.ling.sms.provider.common.Provider;
import org.ling.sms.web.module.CORSFilter;
import org.ling.sms.web.module.RestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


public class RestService extends AbstractService {

  private static final Logger LOG = LoggerFactory.getLogger(RestService.class);

  private Server server;
  private Configuration conf;
  private Provider provider;
  private DataManager dataManager;

  public RestService(Configuration conf, Provider provider, DataManager dataManager) {
    this.conf = conf;
    this.provider = provider;
    this.dataManager = dataManager;
  }

  public void serviceInit() {

    this.server = new Server(this.conf.getInt(ConfigConstant.SMS_ADDRESS, ConfigConstant.DEFAULT_SMS_ADDRESS));
    ServletContextHandler context = new ServletContextHandler();
    server.setSessionIdManager(new HashSessionIdManager());
    context.setContextPath("");
    server.setHandler(context);
    context.addEventListener(new RestListener(this.conf, this.provider, this.dataManager));
    context.addFilter(CORSFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
    context.addServlet(DispatcherServlet.class, "/");
    SessionHandler sessionHandler = new SessionHandler();
    context.setSessionHandler(sessionHandler);
  }

  public void serviceStart() {
    try {
      server.start();
      server.join();
    } catch (Exception e) {
      LOG.error("Unable to start the web server: ", e);
    }
  }
}

