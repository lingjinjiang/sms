package org.ling.sms.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.ling.sms.datamanager.DataManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

public class DetailPage extends AbstarctPage {

  private transient final DataManager dataManager;

  private Gson gson;

  @Inject
  public DetailPage(DataManager dataManager) {
    this.dataManager = dataManager;
    this.gson = new Gson();
  }

  public void render(HttpServletRequest req, HttpServletResponse resp) {
    PrintWriter writer = null;
    try {
      writer = resp.getWriter();
      Map<String, String[]> paraMap = req.getParameterMap();
      StringBuilder content = new StringBuilder();
      content.append("<!doctype html>");
      content.append("<html lang=\"zh-CN\">");
      content.append("<head>");
      content.append("<meta charset=\"UTF-8\">");
      content.append("<title>报告详情</title>");
      content.append("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"/static/css/weui.min.css\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"/static/css/jquery-weui.min.css\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"/static/css/base.css\">\n");
      content.append("\t<link rel=\"stylesheet\" href=\"/static/css/show.css\">\n");
      content.append("</head>\n");
      content.append("<body>\n");

      String clinicCode = paraMap.get("clinicCode")[0];
      String type = paraMap.get("type")[0];
      String result = dataManager.getReportDetail("{\"clinicCode\":\"" + clinicCode + "\", \"type\":\"" + type + "\"}");

      QueryResult qr = gson.fromJson(result, QueryResult.class);

      result = qr.getD();
      int position = result.indexOf("}]}") + 3;
      UserInfos userInfos = gson.fromJson(result.substring(1, position), UserInfos.class);
      for (UserInfos.User user : userInfos.getUserInfo()) {
        content.append("<div id='title' class='title'>报告详情</div>");
        content.append("<div id='userInfo'>");
        content.append("<table class='userInfo'>");
        content.append("<tbody>");
        content.append("<tr>");
        content.append("<td class='userInfoTd'>病历号：<span id='patientNo'>").
                append(user.getId()).
                append("</span></td>");
        content.append("<td class='userInfoTd'>检查日期：<span id='chekDate'>").
                append(user.getChekDate()).
                append("</span></td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td class='userInfoTd'>姓名：<span id='name'>").
                append(user.getPatientName()).
                append("</span></td>");
        content.append("<td class='userInfoTd'>年龄：<span id='age'>").
                append(user.getAge()).
                append("</span></td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td class='userInfoTd'>性别：<span id='gender'>").
                append(user.getSex()).
                append("</span></td>");
        content.append("<td class='userInfoTd'>科室：<span id='deptName'>").
                append(user.getDeptName()).
                append("</span></td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td class='userInfoTd'>检查项目：<span id='label'>").
                append(user.getLabel()).
                append("</span></td>");
        content.append("<td class='userInfoTd'>医生：<span id='doctor'>").
                append(user.getDoctor()).
                append("</span></td>");
        content.append("</tr>");
        content.append("</tbody>");
        content.append("</table>");
        content.append("</div>");
      }

      content.append("<div id='detail'>");
      CheckItems items = gson.fromJson((result.substring(position + 1, result.length() - 1)), CheckItems.class);
      for (CheckItems.CheckItem item : items.getLisDetial()) {
        String color = "#00AA00";
        String flag = item.getFlag();
        String checkResult = item.getResult();
        if ("↑".equals(flag) || "↓".equals(flag)) {
          color = "#FF0000";
          checkResult = flag + ' ' + checkResult;
        }

        content.append("<div class='detail'>");
        content.append("<table>");
        content.append("<tr>");
        content.append("<td class='bottom-dashed'><span class='result'>").
                append(item.getName()).append("</span></td>");
        content.append("<td class='right-td bottom-dashed'><span class='result' style='color: " + color + ";'>").
                append(checkResult).append("</span></td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td><span>单位: ").
                append(item.getUnit()).append("</span></td>");
        content.append("<td class='right-td'><span>参考值: ").
                append(item.getRange()).append("</span></td>");
        content.append("</tr>");
        content.append("</table>");
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
