package com.ibm.abn.hackathon.bot.beans;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Refererral {
	
	
	private String ref;
	private String source;
	private String type;
	
	
	
	@JsonCreator
	public Refererral(@JsonProperty("ref")String ref, @JsonProperty("ref")String source, @JsonProperty("ref")String type) {
		super();
		this.ref = ref;
		this.source = source;
		this.type = type;
	}
	
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
