package org.ling.sms.provider.common;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

public interface Provider {
  public void serviceInit();

  SendSmsResponse sendMessage(String phoneNum, String message) throws ClientException;

  QuerySendDetailsResponse querySendDetails(String phoneNum, String message, String bizId) throws ClientException;
}
