package io.sunculture.SendToEventHub.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.lang.Integer;
import java.lang.String;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "device_metrics_tbl")
public class Metric {

    @DynamoDBHashKey
    private String deviceId;
    @DynamoDBAttribute
    private String eventProcessedUtcTime;
    @DynamoDBAttribute
    private String outputVoltage;
    @DynamoDBAttribute
    private String panelCurrent;
    @DynamoDBAttribute
    private Integer partitionId;
    @DynamoDBAttribute
    private String outputCurrent;
    @DynamoDBAttribute
    private String batteryVoltage;
    @DynamoDBAttribute
    private String RSSI;
    @DynamoDBAttribute
    private IoTHub IoTHub;
    @DynamoDBAttribute
    private String eventTime;
    @DynamoDBAttribute
    private String panelVoltage;
    @DynamoDBAttribute
    private String eventEnqueuedUtcTime;
    @DynamoDBAttribute
    private String freeHeapSize;

    @Override
    public String toString() {
        return "Metric{" +
                "eventProcessedUtcTime='" + eventProcessedUtcTime + '\'' +
                ", outputVoltage='" + outputVoltage + '\'' +
                ", panelCurrent='" + panelCurrent + '\'' +
                ", partitionId=" + partitionId +
                ", deviceId='" + deviceId + '\'' +
                ", outputCurrent='" + outputCurrent + '\'' +
                ", batteryVoltage='" + batteryVoltage + '\'' +
                ", RSSI='" + RSSI + '\'' +
                ", IoTHub=" + IoTHub +
                ", eventTime='" + eventTime + '\'' +
                ", panelVoltage='" + panelVoltage + '\'' +
                ", eventEnqueuedUtcTime='" + eventEnqueuedUtcTime + '\'' +
                ", freeHeapSize='" + freeHeapSize + '\'' +
                '}';
    }
}

