package io.sunculture.SendToEventHub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "azure", ignoreUnknownFields = false)
public class AzureConfig {

    private String connectionString;
    private String eventHubName;
    private String consumerGroup;
    private String storageConnectionString;
    private String storageContainer;
}
