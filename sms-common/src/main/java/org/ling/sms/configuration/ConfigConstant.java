package org.ling.sms.configuration;

public class ConfigConstant {

  public static final String SMS_ADDRESS = "sms.address";
  public static final String DEFAULT_SMS_ADDRESS = "0.0.0.0:8080";

  public static final String SMS_PREFIX = "sms.provider";

  public static final String SMS_PROVIDER = SMS_PREFIX + ".class";
  public static final String DEFAULT_SMS_PROVIDER = "org.ling.sms.provider.aliyun.AliyunProvider";

  public static final String ALIYUN_ACCESSKEY_ID = SMS_PREFIX + ".aliyun.access.key.id";

  public static final String ALIYUN_ACCESSKEY_SECRET = SMS_PREFIX + ".aliyun.access.key.secret";

  public static final String ALIYUN_SIGN_NAME = SMS_PREFIX + ".aliyun.sign.name";

  public static final String ALIYUN_TEMPLATE_CDDE = SMS_PREFIX + ".aliyun.template.code";

}
