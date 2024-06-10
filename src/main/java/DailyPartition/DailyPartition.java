package DailyPartition;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DailyPartition {

    public Dataset<Row> calculate(SparkSession spark){
        System.out.println("Calculate!!");
        Dataset<Row> data = spark.read().option("header", "true").csv("/Users/kimkyungmin/Desktop/archive/2019-Oct.csv");
        return data;
    }

    public void show(Dataset<Row> data){
        data.show();
    }
}
