package com.ibm.abn.hackathon.bot.beans;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Entry {
	

	private String id;

	private String time;

	private List<Messaging> messaging;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@JsonCreator
	public Entry(@JsonProperty("id")String id, @JsonProperty("time")String time, @JsonProperty("messaging")List<Messaging> messaging) {
		super();
		this.id = id;
		this.time = time;
		this.messaging = messaging;
	}
	public List<Messaging> getMessaging() {
		return messaging;
	}
	public void setMessaging(List<Messaging> messaging) {
		this.messaging = messaging;
	}


}
