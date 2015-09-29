package org.test.boot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.test.service.DepartmentJpaService;

@ControllerAdvice
public class BootExceptionHandler {

	@Autowired
	protected DepartmentJpaService jpaService;
	
	@ExceptionHandler(CustomSqlException.class)
	public ResponseEntity<String> handleSqlException(){
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@ExceptionHandler(Error.class)
	public ModelAndView handleError(HttpServletRequest request){
		return new ModelAndView("redirect: /test/login");
	}
}
