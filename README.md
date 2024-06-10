-- spark-3.5.1-bin-hadoop3 설치
https://spark.apache.org/downloads.html

-- java 버전
openjdk 17.0.9 2023-10-17

-- 해제
tar xvf spark-3.5.1-bin-hadoop3.tgz

-- 경로 설정(~/.zshrc에 추가)
export SPARK_HOME=~/path/to/spark-3.5.1-bin-hadoop3
export PATH=$SPARK_HOME/bin:$PATH
source ~/.zshrc

-- 경로 확인
echo $SPARK_HOME

-- hostname 설정
sudo hostname -s 127.0.0.1

-- 빌드
mvn package

-- 실행(IllegalAccessError 발생시, --add-opens 옵션 추가)
java --add-opens java.base/sun.nio.ch=ALL-UNNAMED -cp target/SparkJavaApp-1.0-SNAPSHOT.jar:$(echo $SPARK_HOME/jars/*.jar | tr ' ' ':') App
