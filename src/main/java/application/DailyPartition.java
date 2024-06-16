package application;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class DailyPartition {

    public static void processing(SparkSession spark){
        // KST 기준 daily partition 처리
        Dataset<Row> data = spark.read()
                .option("header", "true")
                .option("inferSchema", "false") // 스키마 추론 비활성화, 속도 향상
                .csv("/Users/kimkyungmin/Desktop/archive/2019-Oct.csv", "/Users/kimkyungmin/Desktop/archive/2019-Nov.csv");

        // kst 변환 컬럼 추가
        data = data.withColumn("event_time_kst", from_utc_timestamp(col("event_time"), "Asia/Seoul"));

        // daily 변환 컬럼 추가
        data = data.withColumn("event_time_kst_date", to_date(col("event_time_kst"), "yyyy-MM-dd"));

        // Snappy 압축을 사용하여 parquet 파일 저장
        data.write()
                .partitionBy("event_time_kst_date")
                .format("parquet")
                .option("compression", "snappy") // Snappy 압축 설정
                .mode("overwrite")
                .save("src/main/resources/dailyPartition");

    }
}
