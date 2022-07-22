package com.nttdata.productosprimarios.common.model.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestHeaderExceptionDTO {
    private String message;
    private String status;
    private String error;

}
