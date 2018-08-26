package org.ling.sms.web;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import org.apache.commons.configuration.Configuration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.webapp.WebAppContext;
import org.ling.sms.common.AbstractService;
import org.ling.sms.configuration.ConfigConstant;
import org.ling.sms.datamanager.DataManager;
import org.ling.sms.provider.common.Provider;
import org.ling.sms.web.module.CORSFilter;
import org.ling.sms.web.module.RestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.net.URL;
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
    server.setSessionIdManager(new HashSessionIdManager());

    ContextHandlerCollection collection = new ContextHandlerCollection();

//    ServletContextHandler context = new ServletContextHandler(collection, "/");
//    context.setContextPath("/");
//    context.addEventListener(new RestListener(this.conf, this.provider, this.dataManager));
//    context.addFilter(CORSFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
//    context.addServlet(DispatcherServlet.class, "/");
//    SessionHandler sessionHandler = new SessionHandler();
//    context.setSessionHandler(sessionHandler);

    RestListener restListener = new RestListener(this.conf, this.provider, this.dataManager);
    Injector injector = restListener.getInjector();

    // For static resources. e.g js, css.
    ServletContextHandler staticContext =
            new ServletContextHandler(collection, "/static");
    URL resUrl = getClass().getClassLoader().getResource("webapps/");
    staticContext.setResourceBase(resUrl.toString() + "/static");
    staticContext.addServlet(DefaultServlet.class, "/*");

    // For main app
    WebAppContext webAppContext = new WebAppContext();
    webAppContext.setResourceBase("/");
    collection.addHandler(webAppContext);

    FilterHolder holder = new FilterHolder();
    holder.setName("guice");
    holder.setClassName(GuiceFilter.class.getName());

    FilterMapping fmap = new FilterMapping();
    fmap.setPathSpecs(new String[]{"/*"});
    fmap.setDispatches(FilterMapping.ALL);
    fmap.setFilterName("guice");

    ServletHandler handler = webAppContext.getServletHandler();
    handler.addFilter(holder, fmap);
    injector.getInstance(GuiceFilter.class);

    server.setHandler(collection);
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

