package com.alimentatec.msproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    //private static final long serialVersionUID = 300002228479017363L;

    //@Pattern(regexp="^[0-9]{10}$", message="The value must be numeric and must has only 10 digits")
    @NotEmpty(message = "The msisdn field cannot be empty")
    private String msisdn;
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="The email is invalid")
    @NotEmpty(message = "The email field cannot be empty")
    private String email;
    //@Pattern(regexp="[^}]+\\\"\\}", message="The value payload must be Json String")
    @NotEmpty(message = "The payLoad field cannot be empty")
    private String payLoad;
}
