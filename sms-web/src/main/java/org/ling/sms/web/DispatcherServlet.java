package org.ling.sms.web;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Singleton
public class DispatcherServlet extends HttpServlet {

  private Injector injector;

  private static final Logger LOG = LoggerFactory.getLogger(DispatcherServlet.class);

  @Inject
  DispatcherServlet(Injector injector) {
    this.injector = injector;
  }


  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.service(req, resp);
    HttpSession session = req.getSession();
    resp.setContentType("text/html;charset=UTF-8");

    String reqPath = req.getRequestURI();
    if ("/".equals(reqPath)) {
      resp.sendRedirect("/index");
    }

    if ("/index".equals(reqPath)) {
      String method = req.getMethod();
      if (method.equals("POST")) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(req.getInputStream(), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }

        session.setAttribute("query", sb.toString());
      } else {
        injector.getInstance(MainPage.class).render(req, resp);
      }
    }


    if ("/list".equals(reqPath)) {
      ListPage listPage = injector.getInstance(ListPage.class);
      listPage.render(req, resp);
    }
//    try {
//      writer = resp.getWriter();
//      writer.write("default servlet" + session.getId() + ' ' + req.getRequestURI());
//    } finally {
//      if (writer != null) {
//        writer.close();
//      }
//    }
  }
}
