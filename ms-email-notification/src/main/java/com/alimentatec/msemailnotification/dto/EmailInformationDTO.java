package com.alimentatec.msemailnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailInformationDTO {

    private String emailToSend;
    private String subject;
    private String body;
}
