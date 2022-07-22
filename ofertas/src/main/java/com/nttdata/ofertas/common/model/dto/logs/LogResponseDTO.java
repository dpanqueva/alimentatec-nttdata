package com.nttdata.ofertas.common.model.dto.logs;

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
public class LogResponseDTO {

    private String nivelLog;
    private String version;
    private Object headers;
    private String fecha;
    private String transaccionId;
    private String funcionalidadId;
    private String cliente;
    private String canal;
    private String clase;
    private String nombreError;
    private String mensajeError;
    /**
     * objects out
     */
    private long tiempoEjecucion;
    private Object responseMS;
    private LogIntegracionDTO logIntegracionDTO;
}
