package com.smart.reads.api.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.smart.reads.api.dao.SmartAccountRepository;
import com.smart.reads.api.entity.SmartAccount;

/**
 * Initialiser class to create test data into In-Memory DB while loading the application.
 *
 */
@Component
public class DataInitializer implements ApplicationRunner {

	private SmartAccountRepository smartAccountRepository;

	@Autowired
	public DataInitializer(SmartAccountRepository smartAccountRepository) {
		this.smartAccountRepository = smartAccountRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Creating 2 records into in-memory DB
		long count = smartAccountRepository.count();
		if(count == 0) {
			SmartAccount sa1 = new SmartAccount();
			sa1.setAccountNumber(new Long(1));
			sa1.setElecId(new Long(11));
			sa1.setGasId(new Long(111));
			sa1.setGasSmartRead(new Long(30482));
			sa1.setElecSmartRead(new Long(10026));
			
			SmartAccount sa2 = new SmartAccount();
			sa2.setAccountNumber(new Long(2));
			sa2.setElecId(new Long(22));
			sa2.setGasId(new Long(222));
			sa2.setGasSmartRead(new Long(20456));
			sa2.setElecSmartRead(new Long(11000));
			
			smartAccountRepository.save(sa1);
			smartAccountRepository.save(sa2);
			
		}
	
	}
}

	