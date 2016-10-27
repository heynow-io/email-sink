package io.heynow.sink.email;

import io.heynow.sink.email.service.EmailServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableConfigurationProperties({
        EmailServiceProperties.class
})
public class EmailSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSinkApplication.class, args);
    }

}
