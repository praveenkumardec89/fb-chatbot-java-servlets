package com.ibm.abn.hackathon.bot.beans;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Postback2 {
	
	private String payload;

	
	
	
	@JsonCreator
	public Postback2(@JsonProperty("payload")String payload) {
		super();
		this.payload = payload;
	}
	


	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
}
