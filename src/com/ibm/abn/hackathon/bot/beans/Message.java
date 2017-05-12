package com.ibm.abn.hackathon.bot.beans;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Message {

	
	
	
	@JsonCreator
	public Message(@JsonProperty("mid")String mid, @JsonProperty("seq")int seq, @JsonProperty("text")String text) {
		super();
		this.mid = mid;
		this.seq = seq;
		this.text = text;
	}
	private String mid;
	
	
	private int seq;
	
	
	private String text;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
}
