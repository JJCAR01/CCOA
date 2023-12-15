package com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion;

import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.*;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import com.ccoa.planeacionestrategica.infraestructura.error.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ConcurrentHashMap;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final ConcurrentHashMap<String, HttpStatus> STATES = new ConcurrentHashMap<>();

    public RestExceptionHandler() {
        STATES.put(LongitudMinExcepcion.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(LongitudMaxExcepcion.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(NoDatoExcepcion.class.getSimpleName(), HttpStatus.NOT_FOUND);
        STATES.put(ValorObligatorioExcepcion.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(ValorCaracteresExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST);
        STATES.put(ValorNombreExcepcion.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(ValorObjetoExcepcion.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(ValorInvalidoExcepcion.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
        STATES.put(ValidadorFecha.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
        STATES.put(AccessDeniedExcepcion.class.getSimpleName(),HttpStatus.INTERNAL_SERVER_ERROR);
        STATES.put(BadRequestExcepcion.class.getSimpleName(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseExcepcion.class)
    public ResponseEntity<Error> exceptionResolver(BaseExcepcion e) {
        HttpStatus status = STATES.get(e.getClass().getSimpleName());
        Error err = new Error(e.getClass().getSimpleName(),e.getMensajeTecnico(),e.getMensajeHumano());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> exceptionResolver(Exception e) {
        Error err = new Error(e.getClass().getSimpleName(), e.getMessage(), ValidadorDominio.MENSAJE_DEFECTO);
        LOGGER.error(e.getClass().getSimpleName(), e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
