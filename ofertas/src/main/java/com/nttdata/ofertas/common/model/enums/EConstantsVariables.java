package com.nttdata.ofertas.common.model.enums;

/**
 * @version 0.0.1
 * @author dpanquev
 * */
public enum EConstantsVariables {

    ERROR_FILTER ("No se encontro información para el filtro usado"),

    SUCCESS ("Información encontrada"),

    PROGRAMMER ("Tarea! generando archivo..."),

    ERROR_REQUEST("El filtro de fechas no puede ser superior a 1 mes"),

    METHOD_NAME("methodName");

    public static final String IS_REQUIRED = " is required ";
    public static final String NOT_NULL = " must not be null";

    public final String label;

    private EConstantsVariables(String label) {
        this.label = label;
    }
}
