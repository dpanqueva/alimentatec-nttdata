package com.alimentatec.usernotify.common.model.dto.response;

import com.alimentatec.usernotify.common.model.enums.EResponseType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {

    private T serviceResponse;
    private EResponseType type;
    private String message;
    private String code;

    public ResponseDTO(EResponseType type, String message, String code) {
        this.type = type;
        this.message = message;
        this.code = code;
    }
}