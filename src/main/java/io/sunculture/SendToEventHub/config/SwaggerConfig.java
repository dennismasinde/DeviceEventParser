package io.sunculture.SendToEventHub.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SunCulture IoT POC",
                version = "1.0.0",
                description = """
                        User Endpoints documentation.
                        """
        ),
        servers= {
                @Server(
                        url="http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}