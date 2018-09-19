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
      Map<String, String[]> paraMap = req.getParameterMap();
      String type = paraMap.get("type")[0];
      String clinicCode = paraMap.get("clinicCode")[0];
      String item = paraMap.get("item")[0];
      String result = dataManager.getReportDetail("{\"clinicCode\":\"" + clinicCode + "\", \"type\":\"" + type + "\"}");

      StringBuilder content = new StringBuilder();

      renderHeader(content);
      renderBody(result, content, item);
      renderBottom(content);

      writer = resp.getWriter();
      writer.write(content.toString());

    } catch (IOException e) {

    }
  }

  private void renderBody(String result, StringBuilder content, String item) {
    QueryResult qr = gson.fromJson(result, QueryResult.class);
    String d = qr.getD();
    int position = d.indexOf("}]}") + 3;

    content.append("<body>\n");

    String userStr = d.substring(1, position);
    UserInfos userInfos = gson.fromJson(userStr, UserInfos.class);
    String detailStr = d.substring(position + 1, d.length() - 1);

//    renderUser(content, userInfos);
    if ("检验".equals(item)) {
      CheckItems items = gson.fromJson(detailStr, CheckItems.class);
      renderUser(content, userInfos);
      renderDetail(content, items);
    } else {
      XRayItems items = gson.fromJson(detailStr, XRayItems.class);
      userInfos.getUserInfo().get(0).setChekDate(items.getPacsDetial().get(0).getReportDate());
      userInfos.getUserInfo().get(0).setDeptName("");
      userInfos.getUserInfo().get(0).setLabel(items.getPacsDetial().get(0).getType());
      userInfos.getUserInfo().get(0).setDoctor(items.getPacsDetial().get(0).getTrier());
      renderUser(content, userInfos);
      renderDetail(content, items);
    }
//    renderDetail(content, detailStr, item);

    content.append("</body>\n");
  }

  private void renderDetail(StringBuilder content, CheckItems items) {
    content.append("<div id='detail'>");
    for (CheckItems.CheckItem checkItem : items.getLisDetial()) {
      String color = "#00AA00";
      String flag = checkItem.getFlag();
      String checkResult = checkItem.getResult();
      if ("↑".equals(flag) || "↓".equals(flag)) {
        color = "#FF0000";
        checkResult = flag + ' ' + checkResult;
      }

      content.append("<div class='detail'>");
      content.append("<table>");
      content.append("<tr>");
      content.append("<td class='bottom-dashed'><span class='result'>").
              append(checkItem.getName()).append("</span></td>");
      content.append("<td class='right-td bottom-dashed'><span class='result' style='color: " + color + ";'>").
              append(checkResult).append("</span></td>");
      content.append("</tr>");
      content.append("<tr>");
      content.append("<td><span>单位: ").
              append(checkItem.getUnit()).append("</span></td>");
      content.append("<td class='right-td'><span>参考值: ").
              append(checkItem.getRange()).append("</span></td>");
      content.append("</tr>");
      content.append("</table>");
      content.append("</div>");
    }
    content.append("</div>");
  }

  private void renderDetail(StringBuilder content, XRayItems items) {
    content.append("<div id='detail'>");
    for (XRayItems.XRayItem xRayItem : items.getPacsDetial()) {
      content.append("<div class='other-detail'>");
      content.append("<p class='other-name'>检查描述</p>");
      content.append("<hr class='detail-hr'/>");
      content.append("<p id='script' class='small_detail' style='text-indent: 2em'>").
              append(xRayItem.getScript().replaceAll("\\r\\n", "").replaceAll(" ", "")).
              append("</p>");
      content.append("</div>");
      content.append("<br/>");
      content.append("<div class='other-detail'>");
      content.append("<p class='other-name'>检查结论</p>");
      content.append("<hr class='detail-hr'/>");
      content.append("<p class='small_detail' style='padding-left: 2em'>").
              append(xRayItem.getResult().replaceAll("\\r\\n", "<br/>")).
              append("</p>");
      content.append("</div>");
    }
    content.append("</div>");
  }

  private void renderDetail(StringBuilder content, String detailStr, String item) {
    content.append("<div id='detail'>");
    if ("检验".equals(item)) {
      CheckItems items = gson.fromJson(detailStr, CheckItems.class);
      for (CheckItems.CheckItem checkItem : items.getLisDetial()) {
        String color = "#00AA00";
        String flag = checkItem.getFlag();
        String checkResult = checkItem.getResult();
        if ("↑".equals(flag) || "↓".equals(flag)) {
          color = "#FF0000";
          checkResult = flag + ' ' + checkResult;
        }

        content.append("<div class='detail'>");
        content.append("<table>");
        content.append("<tr>");
        content.append("<td class='bottom-dashed'><span class='result'>").
                append(checkItem.getName()).append("</span></td>");
        content.append("<td class='right-td bottom-dashed'><span class='result' style='color: " + color + ";'>").
                append(checkResult).append("</span></td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td><span>单位: ").
                append(checkItem.getUnit()).append("</span></td>");
        content.append("<td class='right-td'><span>参考值: ").
                append(checkItem.getRange()).append("</span></td>");
        content.append("</tr>");
        content.append("</table>");
        content.append("</div>");
      }
    } else {
      XRayItems items = gson.fromJson(detailStr, XRayItems.class);
      for (XRayItems.XRayItem xRayItem : items.getPacsDetial()) {
        content.append("<div class='other-detail'>");
        content.append("<p class='other-name'>检查描述</p>");
        content.append("<hr class='detail-hr'/>");
        content.append("<p id='script' class='small_detail' style='text-indent: 2em; padding-left: 0'>").
                append(xRayItem.getScript().replaceAll("\\r\\n", "").replaceAll(" ", "")).
                append("</p>");
        content.append("</div>");
        content.append("<br/>");
        content.append("<div class='other-detail'>");
        content.append("<p class='other-name'>检查结论</p>");
        content.append("<hr class='detail-hr'/>");
        content.append("<p class='small_detail' style='padding-left: 2em'>").
                append(xRayItem.getResult().replaceAll("\\r\\n", "<br/>")).
                append("</p>");
        content.append("</div>");
      }
    }
    content.append("</div>");
  }

  private void renderUser(StringBuilder content, UserInfos userInfos) {
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
              append(user.getName()).
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
  }

  private void renderBottom(StringBuilder content) {
    content.append("</html>\n");
    content.append("<script src=\"/static/js/jquery.min.js\"></script>\n");
    content.append("<script src=\"/static/js/jquery-weui.min.js\"></script>\n");
    content.append("<script src=\"/static/js/jquery.cookie.js\"></script>\n");
  }

  private void renderHeader(StringBuilder content) {
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
  }
}
