package com.ibm.abn.hackathon.bot.beans;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Postbackjsonmessage {
	
	private Sender sender;
	private Recipent recipent;
	private String  timestamp;
	private Postback postback;

	
	@JsonCreator
	public Postbackjsonmessage(@JsonProperty("sender")Sender sender, @JsonProperty("recipent")Recipent recipent, @JsonProperty("timestamp")String timestamp, @JsonProperty("postback")Postback postback) {
		super();
		this.sender = sender;
		this.recipent = recipent;
		this.timestamp = timestamp;
		this.postback = postback;
	}


	public Sender getSender() {
		return sender;
	}


	public void setSender(Sender sender) {
		this.sender = sender;
	}


	public Recipent getRecipent() {
		return recipent;
	}


	public void setRecipent(Recipent recipent) {
		this.recipent = recipent;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public Postback getPostback() {
		return postback;
	}


	public void setPostback(Postback postback) {
		this.postback = postback;
	}
	
	

}
