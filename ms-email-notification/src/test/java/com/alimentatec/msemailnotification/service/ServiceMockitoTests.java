package com.alimentatec.msemailnotification.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ServiceMockitoTests {

    @InjectMocks
    private NotificationEmailServiceImpl notificationEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    void sendEmail(){
        String email = "jmartinez79@uan.edu.co";
        String subject = "This is Subject";
        String body = "This is Body";
        Assertions.assertDoesNotThrow(() -> notificationEmailService.SendNotificationEmail(email, subject, body));
    }
}
