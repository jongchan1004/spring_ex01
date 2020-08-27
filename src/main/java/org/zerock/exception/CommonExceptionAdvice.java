package org.zerock.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Order(1) //ControllerAdvice가 여러개 일때 순서 정함 11:25
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}
	
//	@ExceptionHandler(Exception.class)
//	public String except(Exception ex) {
//		log.error("Exception........" + ex.getMessage());
//		return "error_page"; //ex가 자바빈 객체가 아닌가??
//	}
	
	//159 page
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
	
}
