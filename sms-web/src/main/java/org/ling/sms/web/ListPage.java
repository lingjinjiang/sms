package org.ling.sms.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.ling.sms.datamanager.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ListPage extends AbstarctPage {


  private transient final DataManager dataManager;

  private Gson gson;

  @Inject
  public ListPage(DataManager dataManager) {
    this.dataManager = dataManager;
    this.gson = new Gson();
  }


  private static final Logger LOG = LoggerFactory.getLogger(ListPage.class);

  public void render(HttpServletRequest req, HttpServletResponse resp) {
    HttpSession session = req.getSession(false);

    String condition = (String) session.getAttribute("query");
    if (condition != null) {
      PrintWriter writer = null;
      try {
        writer = resp.getWriter();
        String result = dataManager.getReportList(condition);
        QueryResult qr = gson.fromJson(result, QueryResult.class);
        ListResult listInfo = gson.fromJson(qr.getD(), ListResult.class);

        StringBuilder content = new StringBuilder();
        content.append("<!doctype html>");
        content.append("<html lang=\"zh-CN\">");
        content.append("<head>");
        content.append("<meta charset=\"UTF-8\">");
        content.append("<title>报告列表</title>");
        content.append("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        content.append("\t<link rel=\"stylesheet\" href=\"/static/css/weui.min.css\">\n");
        content.append("\t<link rel=\"stylesheet\" href=\"/static/css/jquery-weui.min.css\">\n");
        content.append("\t<link rel=\"stylesheet\" href=\"/static/css/base.css\">\n");
        content.append("\t<link rel=\"stylesheet\" href=\"/static/css/list.css\">\n");
        content.append("</head>\n");
        content.append("<body>\n");
        content.append("<div class='title'>查询结果</div>");
        content.append("<br/>");
        content.append("<div id='container'>");

        if (listInfo != null) {
          List<ListResult.ReportInfo> reportInfos = listInfo.getLisInfo();
          for (ListResult.ReportInfo report : reportInfos) {

            String reportColor = "#38afdc";
            if (reportInfos.indexOf(report) % 2 == 0) {
              reportColor = "#ff9800";
            }

            String href = "/detail?clinicCode=" + report.getClinicCode() + "&type=" + report.getType() + "&item=" + report.getItem();
            content.append("<div class=\"report\">");
            content.append("  <a href=\"" + href + "\">");
            content.append("    <div class=\"report-title\" style=\"background: " + reportColor + "\">");
            content.append("      检验报告");
            content.append("    </div>");
            content.append("    <div class=\"report-info\">");
            content.append("      <div style=\"font-size: 25px; margin-right: 10px; padding-top: 10px;\">");
            content.append(report.getType());
            content.append("      </div>");
            content.append("      <hr class=\"split\"/>");
            content.append("      <div style=\"font-size: 15px; margin-right: 10px;\">");
            content.append(report.checkDate);
            content.append("      </div>");
            content.append("    </div>");
            content.append("  </a>");
            content.append("</div>");
            content.append("<hr style=\"margin: 3px; visibility: hidden;\"/>");
          }
        } else {
          content.append("<div class=\"report\" style=\"font-size: 50px; margin-top: 75px; text-align: center;\">");
          content.append("没有找到结果");
          content.append("</div>");
        }

        content.append("</div>");
        content.append("</body>\n");
        content.append("</html>\n");
        content.append("<script src=\"/static/js/jquery.min.js\"></script>\n");
        content.append("<script src=\"/static/js/jquery-weui.min.js\"></script>\n");
        content.append("<script src=\"/static/js/jquery.cookie.js\"></script>\n");

        writer.write(content.toString());

      } catch (IOException e) {

      }
    }
  }
}
