package com.baclays.assignment.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidTradeException extends RuntimeException {
	
	private  Long tradeID;
	
	
	public InvalidTradeException(Long Id) {
		super(String.format("Trade with trade id : %s is not valid",Id));
		this.tradeID=Id;
	}
	
	

}
