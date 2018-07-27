package org.ling.sms.provider.common;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

public class EmptyProvider implements Provider{
  public void serviceInit() {

  }

  public SendSmsResponse sendMessage(String phoneNum, String message) throws ClientException {
    return null;
  }

  public QuerySendDetailsResponse querySendDetails(String phoneNum, String message, String bizId) throws ClientException {
    return null;
  }
}
