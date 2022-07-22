package com.alimentatec.msemailnotification.service;

public interface INotificationEmailService {
    public void SendNotificationEmail(String toEmail, String subject, String body);
}
