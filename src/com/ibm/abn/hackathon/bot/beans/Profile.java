package com.ibm.abn.hackathon.bot.beans;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Profile {
	
	private String first_name;
	private String last_name;
	private String locale;
	private String timezone;
	private String gender;
	
	
	
	
	@JsonCreator
	public Profile(@JsonProperty("first_name")String first_name, 
			@JsonProperty("last_name")String last_name, 
			@JsonProperty("locale")String locale, 
			@JsonProperty("timezone")String timezone, 
			@JsonProperty("gender")String gender) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.locale = locale;
		this.timezone = timezone;
		this.gender = gender;
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	

}
