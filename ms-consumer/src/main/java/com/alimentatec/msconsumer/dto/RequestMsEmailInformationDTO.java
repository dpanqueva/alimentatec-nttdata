package com.alimentatec.msconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestMsEmailInformationDTO {

    private String emailToSend;
    private String subject;
    private String body;
}
