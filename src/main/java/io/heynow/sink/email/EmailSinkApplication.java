package io.heynow.sink.email;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.EmailServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({
		EmailServiceProperties.class
})
public class EmailSinkApplication {

    @Bean
    @Autowired
    public String hehehehe(EmailService hehe) {
        hehe.sendEmail("lamparskikacper@gmail.com", "Test", "<b>heheszki</b>");
        return "lol";
    }

	public static void main(String[] args) {
		SpringApplication.run(EmailSinkApplication.class, args);
	}

}
