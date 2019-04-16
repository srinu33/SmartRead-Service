package com.smart.reads.api.util;

public class SmartError {

	private String errorMessage;
	
	private Long accountNumber;
	 
    public SmartError(String errorMessage, Long accountNumber){
        this.errorMessage = errorMessage;
        this.accountNumber = accountNumber;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public Long getAccountNumber() {
        return accountNumber;
    }
    
}
