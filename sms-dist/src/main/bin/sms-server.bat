@echo off

set CFGDIR=%~dp0%..\conf

set SMS_LOG_DIR=%~dp0%..\log

set APP_CLASSPATH=%~dp0..\*;%~dp0..\lib\*;%CFGDIR%

set JAVA_OPTS="-Xms50m -Xmx100m"

set MAIN_CLASS=org.ling.sms.server.SmsServer

java %APP_OPTS% -cp %APP_CLASSPATH% -Dsms.log.dir=%SMS_LOG_DIR% %MAIN_CLASS%