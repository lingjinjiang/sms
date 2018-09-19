#!/bin/sh
MYNAME=${BASH_SOURCE-$0}
BIN_DIR=$(dirname $MYNAME)
BASE_DIR=$(cd ${BIN_DIR}/.. ; pwd)

if [ "x${JAVA_HOME}" = "x" ]; then
  echo "The JAVA_HOME is not setted."
  exit -1
fi

if [ $# -lt 1 ]; then
  echo "usage: sms-server.sh start | stop"
  exit 0
fi

SMS_PID_FILE=${BASE_DIR}/SmsServer.pid

JAVA_BIN=${JAVA_HOME}/bin/java

#APP_OPTS="-Xms50m -Xmx100m"
APP_CLASSPATH=${BASE_DIR}/*:${BASE_DIR}/conf:${BASE_DIR}/lib/*

SMS_LOG_DIR=${SMS_LOG_DIR:-${BASE_DIR}/log}
if [ ! -d $SMS_LOG_DIR ]; then
  mkdir -p $SMS_LOG_DIR
fi

OPERATION=$1
if [ $OPERATION = "start" ]; then
  ${JAVA_BIN} ${APP_OPTS} -cp ${APP_CLASSPATH} -Dsms.log.dir=$SMS_LOG_DIR org.ling.sms.server.SmsServer &
  echo $! > $SMS_PID_FILE
elif [ $OPERATION = "stop" ]; then
  if [ ! -z $SMS_PID_FILE ]; then
    kill $(cat $SMS_PID_FILE)
  fi
else
  echo "Unknown operation"
fi
