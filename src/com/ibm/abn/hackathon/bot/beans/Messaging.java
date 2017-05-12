package com.ibm.abn.hackathon.bot.beans;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Messaging {
	

	
	@JsonCreator
	public Messaging(@JsonProperty("sender")Sender sender, @JsonProperty("recipent")Recipent recipent, @JsonProperty("timestamp")String timestamp, @JsonProperty("message")Message message) {
		super();
		this.sender = sender;
		this.recipent = recipent;
		this.timestamp = timestamp;
		this.message = message;
	}
	

	
	private Sender sender;
	

	private Recipent recipent;
	

	private String  timestamp;
	

	private Message message;
	
	

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
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	

}
