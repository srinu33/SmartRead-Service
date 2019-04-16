package com.smart.reads.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SMART_ACCOUNT")
public class SmartAccount {

	@Id
    @Column(name = "Account_Number", nullable = false)
    private Long accountNumber;
	
	@Column(name = "Gas_Id", nullable = false)
	private Long gasId;
	  
	@Column(name = "Elec_Id", nullable = false)
	private Long elecId;
	
	@Column(name = "Gas_Smart_Read", nullable = false)
	private Long gasSmartRead;
	  
	@Column(name = "Elec_Smart_Read", nullable = false)
	private Long elecSmartRead;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getGasId() {
		return gasId;
	}

	public void setGasId(Long gasId) {
		this.gasId = gasId;
	}

	public Long getElecId() {
		return elecId;
	}

	public void setElecId(Long elecId) {
		this.elecId = elecId;
	}

	public Long getGasSmartRead() {
		return gasSmartRead;
	}

	public void setGasSmartRead(Long gasSmartRead) {
		this.gasSmartRead = gasSmartRead;
	}

	public Long getElecSmartRead() {
		return elecSmartRead;
	}

	public void setElecSmartRead(Long elecSmartRead) {
		this.elecSmartRead = elecSmartRead;
	}
	
}
