package com.smart.reads.api.model;

public class MeterRead {
	
	private long gasRead;
	
	private long electrictyRead;

	public long getGasRead() {
		return gasRead;
	}

	public void setGasRead(long gasRead) {
		this.gasRead = gasRead;
	}

	public long getElectrictyRead() {
		return electrictyRead;
	}

	public void setElectrictyRead(long electrictyRead) {
		this.electrictyRead = electrictyRead;
	}

	@Override
	public String toString() {
		return "gasRead=" + gasRead + ", electrictyRead="
				+ electrictyRead;
	}
	

}
