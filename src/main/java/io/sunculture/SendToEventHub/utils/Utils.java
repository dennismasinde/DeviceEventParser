package io.sunculture.SendToEventHub.utils;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.models.ErrorContext;
import com.azure.messaging.eventhubs.models.EventContext;
import com.azure.messaging.eventhubs.models.PartitionContext;
import io.sunculture.SendToEventHub.config.AzureConfig;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Utils {

    private final AzureConfig azureConfig;
    public static final String connectionString = "Endpoint=sb://sun-iot-eventhub-namespace.servicebus.windows.net/;SharedAccessKeyName=sun-IoT-sendReceive-conn-string;SharedAccessKey=IGcbhIHzd/F0UC41h+NEgUPl6oAYSn1QQ+AEhMe+gok=";
    public static final String eventHubName = "sun-iot-eventhub-1";

    public static final String consumerGroup = "$Default";

    public static final String storageConnectionString = "<Storage connection string>";
    public static final String storageContainerName = "<Storage container name>";

    public static final Consumer<EventContext> PARTITION_PROCESSOR = eventContext -> {
        PartitionContext partitionContext = eventContext.getPartitionContext();
        EventData eventData = eventContext.getEventData();

        System.out.printf("Processing event from partition %s with sequence number %d with body: %s%n",
                partitionContext.getPartitionId(),
                eventData.getSequenceNumber(),
                eventData.getBodyAsString());

        // Every 10 events received, it will update the checkpoint stored in Azure Blob Storage.
        if (eventData.getSequenceNumber() % 10 == 0) {
            eventContext.updateCheckpoint();
        }
    };

    public static final Consumer<ErrorContext> ERROR_HANDLER = errorContext -> {
        System.out.printf("Error occurred in partition processor for partition %s, %s.%n",
                errorContext.getPartitionContext().getPartitionId(),
                errorContext.getThrowable());
    };
}
