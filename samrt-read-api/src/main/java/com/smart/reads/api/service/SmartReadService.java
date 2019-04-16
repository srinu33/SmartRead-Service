package com.smart.reads.api.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.reads.api.dao.SmartAccountRepository;
import com.smart.reads.api.entity.SmartAccount;
import com.smart.reads.api.model.MeterRead;

/*
 *  Service to retrieve Smart meter readings for an account.
 */
@Service
public class SmartReadService {
	
	public static final Logger logger = LoggerFactory.getLogger(SmartReadService.class);

	@Autowired
    private SmartAccountRepository smartAccountRepository;
	
	public MeterRead getMeterRead(Long accountNumber) {
		MeterRead mr = null;
		
		try {
			Optional<SmartAccount> sa = smartAccountRepository.findById(accountNumber);
			if(sa.isPresent()) {
				mr= new MeterRead();
				mr.setGasRead(sa.get().getGasSmartRead());
				mr.setElectrictyRead(sa.get().getElecSmartRead());
			}
		} catch (Exception e) {
			logger.error("Exception occurred while retieving details." + e);
			return mr;
		}
		
		return mr;
	}
	
}
