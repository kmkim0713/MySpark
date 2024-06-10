import DailyPartition.DailyPartition;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class App {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark Example")
                .master("local[*]")
                .config("spark.driver.host","127.0.0.1")
                .config("spark.driver.bindAddress", "127.0.0.1")
                .config("spark.sql.legacy.timeParserPolicy", "LEGACY")
                .getOrCreate();

        DailyPartition dailyPartition = new DailyPartition();
        dailyPartition.calculate(spark);

        spark.stop();
    }
}



