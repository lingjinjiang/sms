package org.ling.sms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Page {
  public void render(HttpServletRequest req, HttpServletResponse resp);
}
