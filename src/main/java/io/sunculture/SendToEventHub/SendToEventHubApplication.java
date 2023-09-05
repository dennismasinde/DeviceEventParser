package io.sunculture.SendToEventHub;

import io.sunculture.SendToEventHub.services.Receiver;
import io.sunculture.SendToEventHub.services.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SendToEventHubApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SendToEventHubApplication.class, args);

		Sender.publishEvents();
		//Receiver.consumeEvents();
	}

}
