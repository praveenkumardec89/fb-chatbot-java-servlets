package com.ibm.abn.hackathon.bot.beans;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Sender {
	
	
	private String id;

	public String getId() {
		return id;
	}
	
	
	@JsonCreator
	public Sender(@JsonProperty("id")String id) {
		super();
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
