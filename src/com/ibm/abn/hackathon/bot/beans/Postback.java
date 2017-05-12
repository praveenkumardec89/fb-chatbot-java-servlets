package com.ibm.abn.hackathon.bot.beans;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Postback {
	
	
	private String payload;
	private Refererral referral;
	
	
	
	@JsonCreator
	public Postback(@JsonProperty("payload")String payload, @JsonProperty("referral")Refererral referral) {
		super();
		this.payload = payload;
		this.referral = referral;
	}
	


	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public Refererral getReferral() {
		return referral;
	}
	public void setReferral(Refererral referral) {
		this.referral = referral;
	}

	
	
}
