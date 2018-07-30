package org.ling.sms.web.module;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends GuiceFilter {
  static final String ACCESS_CONTROL_ALLOW_ORIGIN =
          "Access-Control-Allow-Origin";

  @Override
  public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
    ServletRequest request = servletRequest;
    ServletResponse response = servletResponse;
    doCrossFilter((HttpServletRequest) request, (HttpServletResponse) response);
    FilterChain chain = filterChain;

    super.doFilter(request, response, chain);
  }

  private void doCrossFilter(HttpServletRequest req, HttpServletResponse res) {
    res.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");

  }
}
