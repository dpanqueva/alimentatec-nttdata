package com.nttdata.ofertassecundarias.common.util;

import com.nttdata.ofertassecundarias.common.model.dto.logs.LogIntegracionDTO;
import com.nttdata.ofertassecundarias.common.model.dto.logs.LogResponseDTO;
import com.nttdata.ofertassecundarias.common.model.dto.logs.PetitionInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Slf4j
@Component
public class ProjectUtils {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Method for build and print object log
     * infoRequest -> body, path Variable, path param
     * logLevel-> error, info
     *
     * @param headers
     * @param responseMS
     * @param logLevel
     */
    @SneakyThrows
    public void printLog(String logLevel, Object headers, Object responseMS, Map<String, Object> isIntegration) {
        LogResponseDTO logResponseDTO = new LogResponseDTO();
        logResponseDTO.setHeaders(headers);
        logResponseDTO.setResponseMS(responseMS);
        logResponseDTO.setCanal(System.getProperty("originator"));
        logResponseDTO.setCliente(System.getProperty("userid"));
        logResponseDTO.setFecha(new Date().toString());
        logResponseDTO.setFuncionalidadId(System.getProperty("operationid"));
        long timeInit = Long.parseLong(System.getProperty("timeInit"));
        logResponseDTO.setTiempoEjecucion(System.currentTimeMillis() - timeInit);
        logResponseDTO.setTransaccionId(System.getProperty("execid"));
        logResponseDTO.setNivelLog(logLevel);
        logResponseDTO.setVersion(buildVersion);
        logResponseDTO.setClase(System.getProperty("methodName"));
        /**
         * for error type event
         * */
        logResponseDTO.setMensajeError(System.getProperty("msnError"));
        logResponseDTO.setNombreError(System.getProperty("errorName"));

        logResponseDTO.setLogIntegracionDTO((!isIntegration.isEmpty()) ? integrationBuild(isIntegration) : null);
        log.info(objectMapper.writeValueAsString(logResponseDTO));
    }

    /**
     * Method for print log integration, for example when consume a client
     *
     * @param isIntegration
     * @return
     */
    private LogIntegracionDTO integrationBuild(Map<String, Object> isIntegration) {
        LogIntegracionDTO logIntegracionDTO = new LogIntegracionDTO();
        logIntegracionDTO.setPeticionInfo(new PetitionInfoDTO(isIntegration.get("headers-client")
                , isIntegration.get("parameter"), null));
        logIntegracionDTO.setTipoPeticion(isIntegration.containsKey("tipoPeticion"));
        logIntegracionDTO.setRespuesta(isIntegration.get("responseClient"));
        logIntegracionDTO.setMetodo(System.getProperty("method"));
        logIntegracionDTO.setEndPoint(System.getProperty("url"));
        logIntegracionDTO.setEstado(System.getProperty("status"));
        return logIntegracionDTO;
    }
}
