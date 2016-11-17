package controller;

import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ErrorHandlerController {

	@ControllerAdvice
	public class ErrorHandler {
		
		@ExceptionHandler(HibernateException.class)
		public String DataBaseErrorHandler(HibernateException ex) {
			//ex.printStackTrace();
			return "error";

		}

	}

	
	
}
