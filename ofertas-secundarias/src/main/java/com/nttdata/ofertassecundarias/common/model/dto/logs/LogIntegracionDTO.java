package com.nttdata.ofertassecundarias.common.model.dto.logs;

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
public class LogIntegracionDTO {

    /**
     * variables de integración
     */
    private Object peticionInfo;
    private String endPoint;
    private String metodo;
    /**
     * OUT
     * */
    private String estado;
    private Object respuesta;
    private Boolean tipoPeticion;
}