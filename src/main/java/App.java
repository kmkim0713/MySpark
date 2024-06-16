import application.DailyPartition;
import org.apache.spark.sql.SparkSession;


public class App {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark")
                .master("local[*]")
                .config("spark.driver.host","127.0.0.1")
                .config("spark.driver.bindAddress", "127.0.0.1")
                .config("spark.sql.legacy.timeParserPolicy", "LEGACY")
                .config("spark.sql.session.timeZone", "UTC") // 로컬환경 타임존 UTC 설정
                .getOrCreate();

        DailyPartition.processing(spark);

        spark.stop();
    }
}



