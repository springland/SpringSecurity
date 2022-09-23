package com.springland365.springsecuritymfa.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("email")
public class EmailServiceTest {

    @Value("${toaddr}")
    String toaddr ;
    @Autowired
    EmailService  emailService;
    @Test
    public void test()
    {
        emailService.sendEmail("noreply@springland365.com" , toaddr , "this is a test email" , " to test email service");
    }
}
