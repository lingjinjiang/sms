package org.ling.sms.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherServlet extends HttpServlet {
  PrintWriter writer;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.service(req, resp);
    HttpSession session = req.getSession();
    resp.setContentType("text/html;charset=UTF-8");
    MainPage mainPage = new MainPage();

    String reqPath = req.getRequestURI();
    if ("/".equals(reqPath)) {
      resp.sendRedirect("/index");
    }

    if ("/index".equals(reqPath)) {
      mainPage.render(req, resp);
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
