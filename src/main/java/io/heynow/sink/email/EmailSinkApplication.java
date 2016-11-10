package io.heynow.sink.email;

import io.heynow.sink.email.service.EmailServiceProperties;
import io.heynow.stream.manager.client.EnableStreamManagerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties({
        EmailServiceProperties.class
})
@EnableCaching
@EnableStreamManagerClient
public class EmailSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSinkApplication.class, args);
    }

}
