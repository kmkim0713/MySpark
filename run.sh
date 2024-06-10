#!/bin/bash

# Maven을 사용하여 프로젝트 빌드
mvn package

# Java 애플리케이션 실행
java --add-opens java.base/sun.nio.ch=ALL-UNNAMED \
  	 --add-opens java.base/sun.util.calendar=ALL-UNNAMED \
    -cp target/SparkJavaApp-1.0-SNAPSHOT.jar:$(echo $SPARK_HOME/jars/*.jar | tr ' ' ':') \
    App

