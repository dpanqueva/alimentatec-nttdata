package com.nttdata.ofertassecundarias.common.enums;

/**
 * @author dpanquev
 * @version 0.0.1
 */
public enum EConstantsVariables {

    ERROR_FILTER("No se encontro información para el filtro usado"),

    SUCCESS("Información encontrada"),

    ERROR_REQUEST("El filtro de fechas no puede ser superior a 1 mes"),

    RECHAZADO("RECHAZADO"),

    SYSTEM("system"),

    OPERATION("operation"),

    EXCETID("execid"),

    TIMESTAMP("timestamp"),

    MSGTYPE("msgtype"),

    OK("OK"),

    TERMINATE_GET_OFFER("Termina el flujo del endpoint -> getRtdOfferByServiceNumber"),

    TERMINATE_CHANGE_OFFER("Termina el flujo del endpoint -> changeOfferToTimeOfferByServiceNumber"),

    KO("KO"),

    RECHAZADO_MSG("La solicitud de cambio de plan no fue exitosa");

    public final String label;

    private EConstantsVariables(String label) {
        this.label = label;
    }
}
