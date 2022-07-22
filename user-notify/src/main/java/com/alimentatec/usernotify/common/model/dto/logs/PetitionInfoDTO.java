package com.alimentatec.usernotify.common.model.dto.logs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetitionInfoDTO {

    private Object headers;
    private Object params;
    private Object requestBody;
}
