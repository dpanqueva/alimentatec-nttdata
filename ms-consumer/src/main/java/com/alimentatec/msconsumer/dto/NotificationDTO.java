package com.alimentatec.msconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    private String msisdn;
    private String email;
    private String payLoad;
}
