package com.vikas.rest;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestDTO {
	
	/**
	 * 
	 */

	private static final Logger logger = LoggerFactory.getLogger(RestDTO.class);
	
	private String type;
	private long sn;
	private long systemId;
	private String[] array;
	
	
	public RestDTO(String callFrom){
		logger.info("Call received from "+callFrom);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSn() {
		return sn;
	}
	public void setSn(long sn) {
		this.sn = sn;
	}
	public long getSystemId() {
		return systemId;
	}
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	} 
	
		
	public String[] getArray(){
		
		return this.array;
	}
	
	public void setArray(String type, long sn, long systemId){
		
		this.array = new String[]{type, String.valueOf(sn), String.valueOf(systemId)};
		
	}
	
}
