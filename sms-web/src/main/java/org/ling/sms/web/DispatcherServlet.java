package org.ling.sms.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherServlet extends HttpServlet {
  PrintWriter writer;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.service(req, resp);
    try {
      writer = resp.getWriter();
      writer.write("default servlet");
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }
}
