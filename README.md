# spark-3.5.1-bin-hadoop3 설치
https://spark.apache.org/downloads.html

# java 버전
openjdk 17.0.9 2023-10-17

# 압축 해제
tar xvf spark-3.5.1-bin-hadoop3.tgz

# 경로 설정(~/.zshrc에 추가)
export SPARK_HOME=~/path/to/spark-3.5.1-bin-hadoop3 <br/>
export PATH=$SPARK_HOME/bin:$PATH <br/>
source ~/.zshrc

# 경로 확인
echo $SPARK_HOME

# hostname 설정
hostname 입력 후 확인 <br>
sudo vi /etc/hosts <br>
127.0.0.1 kimkyungminui-MacBookPro.local 추가


# 빌드
mvn package

# 실행(IllegalAccessError 발생시, --add-opens 옵션 추가)
java --add-opens java.base/sun.util.calendar=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED -cp target/SparkJavaApp-1.0-SNAPSHOT.jar:$(echo $SPARK_HOME/jars/*.jar | tr ' ' ':') App



# kaggle 데이터셋 정의
-- event_time: 이벤트 발생시간 (UTC) <br/>
-- event_type: 이벤트 유형 [view, cart, remove_from_cart, purchase]<br/>
-- product_id: 제품 ID <br/>
-- category_id: 제품 카테고리 ID <br/>
-- category_code: 카테고리 명(null) <br/>
-- brand: 브랜드명(소문자, null) <br/> 
-- price: 가격 <br/>
-- user_id: 유저 ID <br/>
-- user_session: 유저 세션 <br/>


