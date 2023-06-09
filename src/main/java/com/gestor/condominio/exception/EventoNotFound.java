package com.gestor.condominio.exception;

public class EventoNotFound extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    public static  String message = "Id não encontrado:  ";

    public EventoNotFound() {
        super(message);
    }
}
