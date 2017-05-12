package com.ibm.abn.hackathon.bot.beans;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class ReadReceipt {
	
	
	private String recipient_id;
	private String message_id;
	
	
	
	@JsonCreator
	public ReadReceipt(@JsonProperty("recipient_id")String recipient_id, @JsonProperty("message_id")String message_id) {
		super();
		this.recipient_id = recipient_id;
		this.message_id = message_id;
	}
	
	
	public String getRecipient_id() {
		return recipient_id;
	}
	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	
	
	

}
