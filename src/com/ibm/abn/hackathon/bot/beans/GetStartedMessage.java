package com.ibm.abn.hackathon.bot.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class GetStartedMessage {

	private String object;
	

	private List<Entry2> entry;
	
	
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}

	
	public List<Entry2> getEntry() {
		return entry;
	}
	public void setEntry(List<Entry2> entry) {
		this.entry = entry;
	}
	@JsonCreator
	public GetStartedMessage(@JsonProperty("object")String object, @JsonProperty("entry")List<Entry2> entry) {
		super();
		this.object = object;
		this.entry = entry;
	}
	public GetStartedMessage() {
		
	}
	
	@Override
	public String toString() {
		return "JsonMessage [object=" + object + ", entry=" + entry + "]";
	}

	
	
	


	
	
	
	
}
