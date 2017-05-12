package com.ibm.abn.hackathon.bot.beans;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Recipent {
	
	

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@JsonCreator
	public Recipent(@JsonProperty("id")String id) {
		super();
		this.id = id;
	}
	
	

}
