package org.zerock.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Order(2)
@Log4j
public class MyControllerAdvice {
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public void handlerArrayIndexOutOfBoundsException() {
		log.warn("array index 넘음.........warn");
		log.info("array index 넘음.........info");
		log.error("array index 넘음.........error");
	}

}
