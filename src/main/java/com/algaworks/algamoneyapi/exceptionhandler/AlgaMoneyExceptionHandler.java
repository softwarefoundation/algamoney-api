package com.algaworks.algamoneyapi.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgaMoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagem = messageSource.getMessage("mensagem.invalida",null, LocaleContextHolder.getLocale());
        String stacktrace = ex.getCause().toString();
        return  handleExceptionInternal(ex,new Erro(mensagem,stacktrace),headers, HttpStatus.BAD_REQUEST, request);
    }

    public class Erro {

        private String mensagem;
        private String stacktrace;

        public Erro(String mensagem, String stacktrace) {
            this.mensagem = mensagem;
            this.stacktrace = stacktrace;
        }

        public String getMensagem() {
            return mensagem;
        }

        public String getStacktrace() {
            return stacktrace;
        }
    }
}
