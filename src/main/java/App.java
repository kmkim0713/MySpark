import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class App {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark Example")
                .master("local[*]")
                .config("spark.driver.bindAddress", "127.0.0.1")
                .getOrCreate();

        Dataset<Row> data = spark.read().option("header", "true").csv("/Users/kimkyungmin/Desktop/archive/2019-Oct.csv");

        data.show();

        spark.stop();
    }
}



