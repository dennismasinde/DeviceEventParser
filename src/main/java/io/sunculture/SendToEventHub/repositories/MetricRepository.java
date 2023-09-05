package io.sunculture.SendToEventHub.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import io.sunculture.SendToEventHub.models.Metric;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
@RequiredArgsConstructor
public class MetricRepository {

    @Autowired
    private final DynamoDBMapper dynamoDBMapper;

    public Metric save(Metric metric) {
        dynamoDBMapper.save(metric);
        return metric;
    }

    public Metric getMetricByDeviceId(String deviceId) {
        return dynamoDBMapper.load(Metric.class, deviceId);
    }

    public String delete(String deviceId) {
        Metric metric = dynamoDBMapper.load(Metric.class,deviceId);
        dynamoDBMapper.delete(metric);
        return "metric deleted!!!!";
    }
}
