package com.Velox.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Velox.Util.ResponseStructure;
@RestControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
	
   @ExceptionHandler
   public ResponseEntity<ResponseStructure<String>> exceptionHandler(IdNotFoundException exception)
   {
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setMessage("Id not Found");
	   structure.setStatus(HttpStatus.NOT_FOUND.value());
	   structure.setObject(exception.getMessage());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	   }

}
