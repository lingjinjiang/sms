package org.ling.sms.datamanager;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.apache.commons.configuration.Configuration;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.ling.sms.common.AbstractService;
import org.ling.sms.provider.common.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class DataManager extends AbstractService {

  private static final Logger LOG = LoggerFactory.getLogger(DataManager.class);

  private enum CAPTCHA {A, B, C,}

  private Provider provider;

  private String name;

  private Configuration conf;

  private CloseableHttpClient httpClient;

  private String baseUrl;

  public DataManager(Configuration conf, Provider provider, String name) {
    this.conf = conf;
    this.provider = provider;
    this.name = name;
    this.httpClient = HttpClients.createDefault();
    this.baseUrl = "http://218.2.176.62:8099/WebService.asmx";
  }


  public String getName() {
    return name;
  }

  @Override
  public void serviceStart() {

  }

  @Override
  public void serviceInit() {
//    provider.serviceInit();
  }


  public int getCaptcha(long phoneNum) {
    int captcha = (int) (Math.random() * 10000);
    SendSmsResponse response;
//    try {
//      response = provider.sendMessage(Long.toString(phoneNum), Integer.toString(captcha));
//      LOG.info("++++++++++++ {}", response.getCode());
//    } catch (ClientException e) {
//      LOG.info("Failed to send message:", e);
//    }
    return captcha;
  }

  public String getReportList(String condition) throws IOException {

//    String condition = "{\n" +
//            " \"cardNo\": \"0000001308\",\n" +
//            " \"begDate\": \"2016/01/01\",\n" +
//            " \"endDate\": \"2018/04/16\"\n" +
//            "}";


    String queryUrl = this.baseUrl + "/GetLisInfo";
    return query(condition, queryUrl);
  }

  public String getReportDetail(String condition) throws IOException {
    String queryUrl = this.baseUrl + "/GetLisDetial";
    return query(condition, queryUrl);
  }

  private String query(String condition, String queryUrl) throws IOException {
    CloseableHttpResponse response = null;
    LOG.info("The query condition {}", condition);
    try {
      HttpPost post = new HttpPost(queryUrl);
      StringEntity entity = new StringEntity(condition, Charset.forName("UTF-8"));
      post.setHeader("Content-Type", "application/json");
      post.setEntity(entity);
      response = httpClient.execute(post);
      String result = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
      LOG.info("query result {}", result);
      return result;
    } finally {
      if (response != null) {
        response.close();
      }
//      httpClient.close();
    }
  }
}
