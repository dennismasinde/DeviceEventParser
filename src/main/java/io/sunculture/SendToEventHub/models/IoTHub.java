package io.sunculture.SendToEventHub.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class IoTHub {

    @DynamoDBAttribute
    private String connectionDeviceGenerationId;
    @DynamoDBAttribute
    private String enqueuedTime;
    @DynamoDBAttribute
    private String connectionDeviceId;
    @DynamoDBAttribute
    private Object correlationId;
    @DynamoDBAttribute
    private Object messageId;

    @Override
    public String toString() {
        return "IoTHub{" +
                "connectionDeviceGenerationId='" + connectionDeviceGenerationId + '\'' +
                ", enqueuedTime='" + enqueuedTime + '\'' +
                ", connectionDeviceId='" + connectionDeviceId + '\'' +
                ", correlationId=" + correlationId +
                ", messageId=" + messageId +
                '}';
    }
}
