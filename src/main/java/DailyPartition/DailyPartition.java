package DailyPartition;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class DailyPartition {

    public Dataset<Row> calculate(SparkSession spark){
        // KST 기준 daily partition 처리
        Dataset<Row> data = spark.read()
                .option("header", "true")
                .option("inferSchema", "false") // 스키마 추론 비활성화, 속도 향상
                .csv("/Users/kimkyungmin/Desktop/archive/2019-Oct.csv", "/Users/kimkyungmin/Desktop/archive/2019-Nov.csv");


        data.withColumn("partition_date", to_date(col("event_time"), "yyyy-MM-dd HH:mm:ss z"));

        data.show();

        return data;
    }
}
