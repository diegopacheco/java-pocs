package com.github.diegopacheco.sandboxspring.config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class SparkConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public SparkSession sparkSession() throws Exception {
        System.setProperty("HADOOP_USER_NAME", System.getProperty("user.name", "spark"));
        System.setProperty("hadoop.home.dir", "/tmp");

        Configuration hadoopConf = new Configuration();
        hadoopConf.set("hadoop.security.authentication", "simple");
        hadoopConf.set("hadoop.security.authorization", "false");
        hadoopConf.set("fs.file.impl", "org.apache.hadoop.fs.RawLocalFileSystem");
        hadoopConf.set("fs.file.impl.disable.cache", "true");
        UserGroupInformation.setConfiguration(hadoopConf);

        SparkConf sparkConf = new SparkConf()
                .setAppName("purchase-processor")
                .setMaster("local[*]")
                .set("spark.sql.streaming.checkpointLocation", "/tmp/spark-checkpoint")
                .set("spark.sql.adaptive.enabled", "true")
                .set("spark.sql.streaming.stateStore.providerClass", "org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider")
                .set("spark.hadoop.security.authentication", "simple")
                .set("spark.hadoop.fs.file.impl", "org.apache.hadoop.fs.RawLocalFileSystem")
                .set("spark.hadoop.fs.file.impl.disable.cache", "true")
                .set("spark.hadoop.validateOutputSpecs", "false")
                .set("spark.hadoop.fs.permissions.umask-mode", "000");

        return SparkSession.builder()
                .config(sparkConf)
                .getOrCreate();
    }
}
