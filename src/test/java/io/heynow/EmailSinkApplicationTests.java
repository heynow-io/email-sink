package io.heynow;

import io.heynow.sink.email.EmailSinkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmailSinkApplication.class)
public class EmailSinkApplicationTests {

    @Test
    public void contextLoads() {
    }

}
