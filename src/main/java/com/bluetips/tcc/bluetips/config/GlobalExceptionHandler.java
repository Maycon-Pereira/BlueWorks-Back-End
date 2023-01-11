package com.bluetips.tcc.bluetips.config;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErro> handle1(MethodArgumentNotValidException ex) {

		HashMap<String, String> erros = new HashMap<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(erro -> erros.put(erro.getField(), erro.getDefaultMessage()));
        return new ResponseEntity<>(new ApiErro(erros), HttpStatus.BAD_REQUEST);
    }

	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public String handleHttpMediaTypeNotAcceptableException() {
	    return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
	}
	
	
	@ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErro> handle2(HttpMessageNotReadableException ex) {
		
		HashMap<String, String> erros = new HashMap<>();
		erros.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(new ApiErro(erros), HttpStatus.BAD_REQUEST);
    }

   

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErro> qualquerexcecao(Exception ex) {
    	
    	HashMap<String, String> erros = new HashMap<>();
    	erros.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(new ApiErro(erros), HttpStatus.NOT_IMPLEMENTED);
    }
    
 
    
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErro> processRuntimeException(RuntimeException ex) {
    	
    	HashMap<String, String> erros = new HashMap<>();
    	erros.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(new ApiErro(erros), HttpStatus.NOT_IMPLEMENTED);
    }

}
