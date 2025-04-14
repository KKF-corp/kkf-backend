#!/bin/sh
java -XX:MaxJavaStackTraceDepth=5000 -XX:-OmitStackTraceInFastThrow \
    -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./log \
    -Xlog:gc=info,safepoint=info:file=./log/kkf-app-gc-`date +%_%H-%M-%S`.log:time,level,pid,tid,tags:filecount=0,filesize=100m \
    -Djava.awt.headless=true \
    $EXTRA_JVM_OPTIONS \
    -jar kkf-app.jar