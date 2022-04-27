package com.baclays.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.baclays.assignment.dao.ApiResponse;
import com.baclays.assignment.exceptions.InvalidTradeException;


@RestControllerAdvice
public class TradeControllerAdvice {
	
	@ExceptionHandler(InvalidTradeException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(InvalidTradeException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}

}
