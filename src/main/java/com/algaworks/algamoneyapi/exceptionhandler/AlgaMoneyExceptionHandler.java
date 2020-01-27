package com.algaworks.algamoneyapi.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class AlgaMoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagem = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String stacktrace = ex.getCause().toString();
        List<Erro> erros = Arrays.asList(new Erro(mensagem, stacktrace));
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = criarListaDeErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<Erro> criarListaDeErros(BindingResult bindResult) {
        List<Erro> erros = new ArrayList<>();
        bindResult.getFieldErrors().forEach(f -> {
            String msg = messageSource.getMessage(f, LocaleContextHolder.getLocale());
            erros.add(new Erro(msg, f.toString()));
        });

        return erros;
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
