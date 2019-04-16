package com.smart.reads.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.smart.reads.api.model.MeterRead;
import com.smart.reads.api.service.SmartReadService;
import com.smart.reads.api.util.SmartError;

/**
 * REST Controller to handle the requests to read Smart mete readings.
 *
 */
@RestController
public class SmartReadController {
	
	public static final Logger logger = LoggerFactory.getLogger(SmartReadController.class);

	@Autowired
	SmartReadService smartReadService;
	
	@RequestMapping("/api/smart/reads/{accountNumber}")
	public ResponseEntity<?> getReading(@PathVariable Long accountNumber) {
		
		MeterRead reading = smartReadService.getMeterRead(accountNumber);
		
		if(reading == null) {
			logger.error("Meter Readings not found for the Account: "+  accountNumber);
            return new ResponseEntity<SmartError>(new SmartError("Meter Readings not Found for this Account.", accountNumber), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MeterRead>(reading, HttpStatus.OK); 

	}
}