package com.ibm.abn.hackathon.bot.beans;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class JsonMessage {
	

	private String object;
	

	private List<Entry> entry;
	
	
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public List<Entry> getEntry() {
		return entry;
	}
	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}
	
	
	@JsonCreator
	public JsonMessage(@JsonProperty("object")String object, @JsonProperty("entry")List<Entry> entry) {
		super();
		this.object = object;
		this.entry = entry;
	}
	public JsonMessage() {
		
	}
	
	@Override
	public String toString() {
		return "JsonMessage [object=" + object + ", entry=" + entry + "]";
	}

	
	
	

}
