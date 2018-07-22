package org.ling.sms.web;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.apache.commons.configuration.Configuration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.ling.sms.common.AbstractService;
import org.ling.sms.configuration.ConfigConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestService extends AbstractService {

  private static final Logger LOG = LoggerFactory.getLogger(RestService.class);

  private Server server;
  private Configuration conf;

  public RestService(Configuration conf) {
    this.conf = conf;
  }

  public void serviceInit() {

    ServletHolder servlet = new ServletHolder(ServletContainer.class);
    servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
    servlet.setInitParameter("com.sun.jersey.config.property.packages", "org.ling.sms.web.api");
    servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

    ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
    handler.setContextPath("/");
    handler.addServlet(servlet, "/*");

    this.server = new Server(conf.getInt(ConfigConstant.SMS_ADDRESS,ConfigConstant.DEFAULT_SMS_ADDRESS));
    this.server.setHandler(handler);
  }

  public void serviceStart() {
    try {
      server.start();
    } catch (Exception e) {
      LOG.error("Unable to start the web server: ", e);
    }
  }
}

