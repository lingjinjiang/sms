package org.ling.sms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainPage extends AbstarctPage {

  private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

  public void render(HttpServletRequest req, HttpServletResponse resp) {
    PrintWriter writer = null;
    try {
      writer = resp.getWriter();

      StringBuilder content = new StringBuilder();
      content.append("<!doctype html>");
      content.append("<html lang=\"zh-CN\">");
      content.append("<head>");
      content.append("<meta charset=\"UTF-8\">");
      content.append("<title>输入信息</title>");
      content.append("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"./static/css/weui.min.css\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"./static/css/jquery-weui.min.css\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"./static/css/index.css\">\n");
      content.append("</head>\n");
      content.append("<body>\n");
      content.append("\t<div class='title'>\n");
      content.append("\t\t<img id='title' src=\"static/img/title.png\">\n");
      content.append("\t</div>\n");
      content.append("\t<div class=\"weui-cells weui-cells_form registerForm\">\n");
      content.append("\t\t<div class=\"weui-cell weui-cell_vcode customForm\">\n");
      content.append("\t\t\t<div class=\"weui-cell__hd\">\n");
      content.append("\t\t\t\t<label class=\"weui-label regiserTitle\">病历号</label>\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t\t<div class=\"weui-cell__bd\">\n");
      content.append("\t\t\t\t<input class=\"weui-input form-control\" type='text' name=\"cardNo\" placeholder=\"输入病历号\" id='cardNo' />\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t</div>\n");
      content.append("\t\t<div class=\"weui-cell weui-cell_vcode customForm\">\n");
      content.append("\t\t\t<div class=\"weui-cell__hd\">\n");
      content.append("\t\t\t\t<label class=\"weui-label regiserTitle\">开始时间</label>\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t\t<div class=\"weui-cell__bd\">\n");
      content.append("\t\t\t\t<input class=\"weui-input form-control\" type='text' name=\"begDate\" placeholder=\"请选择开始日期\" id='begDate' readonly=\"readonly\"/>\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t</div>\n");
      content.append("\t\t<div class=\"weui-cell weui-cell_vcode customForm\">\n");
      content.append("\t\t\t<div class=\"weui-cell__hd\">\n");
      content.append("\t\t\t\t<label class=\"weui-label regiserTitle\">结束时间</label>\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t\t<div class=\"weui-cell__bd\">\n");
      content.append("\t\t\t\t<input class=\"weui-input form-control\" type='text' name=\"endDate\" placeholder=\"请选择结束日期\" id='endDate' readonly=\"readonly\"/>\n");
      content.append("\t\t\t</div>\n");
      content.append("\t\t</div>\n");
      content.append("\t</div>\n");
      content.append("\t<div class=\"weui-btn-area\">\n");
      content.append("\t\t<div class=\"weui-btn weui-btn_primary\">\n");
      content.append("\t\t\t<a class=\"weui-btn\" id=\"showTooltips\" style='z-index:222;'>查询</a>\n");
      content.append("\t\t</div>\n");
      content.append("\t</div>\n");
      content.append("</body>\n");
      content.append("</html>\n");
      content.append("<script src=\"./static/js/jquery.min.js\"></script>\n");
      content.append("<script src=\"./static/js/jquery-weui.min.js\"></script>\n");
      content.append("<script src=\"./static/js/jquery.cookie.js\"></script>\n");
      content.append("<script src='./static/js/base.js'></script>\n");
      content.append("<script src='./static/js/query.js'></script>\n");

      writer.write(content.toString());

    } catch (IOException e) {

    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }
}
