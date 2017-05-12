package com.ibm.abn.hackathon.bot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import com.ibm.abn.hackathon.bot.beans.GetStartedMessage;
import com.ibm.abn.hackathon.bot.beans.JsonMessage;
import com.ibm.abn.hackathon.bot.beans.Profile;
import com.ibm.abn.hackathon.bot.interfaces.Accesstokens;

public class Connections {
	HttpURLConnection conn=null;
	ObjectMapper mapper=null;
	BufferedReader br = null;
	
	
	// this will give you the user profile
	@SuppressWarnings("static-access")
	public String getProfile(String id) throws IOException {
		conn=getUrlConnection(Accesstokens.urlForGettingProfilepart1+id+Accesstokens.urlForGettingProfilepart2+Accesstokens.page_access_token);
		conn.setRequestMethod("GET");
		mapper = getJsonObjectMapper();
		br = getInputStream(conn);
		Profile messageinput = mapper.readValue(br.readLine(), Profile.class);//.readTree(json); 
		return messageinput.getFirst_name();
	}
	
	public void sendGreeting(String id) throws IOException, JSONException{
		conn=getUrlConnection(Accesstokens.url);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		
		JSONObject json      = new JSONObject();//object created
		JSONObject recipient      = new JSONObject();
		JSONObject message      = new JSONObject();
		try {
			message.put("text", "Hello");
			recipient.put("id", id);
			json.put("recipient", recipient);
			json.put("message", message);
			System.out.println(json.toString());
			OutputStream os = conn.getOutputStream();
			os.write(json.toString().getBytes());
			os.flush();
			System.out.println("executed");	
		} catch (IOException e) {

			e.printStackTrace();

		 }
	}

	
	//this will give you an opened HTTP connection to the given address
	public HttpURLConnection getUrlConnection(String address) throws IOException{
		URL url = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Accept", "application/json");
		return conn;	
	}
	
	
	//this will give you the JSON object mapper
	// you can use to map to the POJOs
	@SuppressWarnings("static-access")
	public ObjectMapper getJsonObjectMapper(){
		   JsonFactory factory = new JsonFactory();
	       ObjectMapper mapper = new ObjectMapper(factory);
	       mapper.configure(Feature.AUTO_DETECT_SETTERS.FAIL_ON_UNKNOWN_PROPERTIES, false); 
	       return mapper;
	
	}
	
	//this will give you the buffered reader read from the connection
	public BufferedReader getInputStream(HttpURLConnection con) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(con.getInputStream())));
		return br;
	}

	public String buildIntialButtons(Object receivedMessage, String type) {
		
		JSONObject json      = new JSONObject();//object created
		JSONObject recipient      = new JSONObject();
		JSONObject message      = new JSONObject();
		JSONObject attachment      = new JSONObject();
		JSONObject temp      = new JSONObject();
		JSONObject payload      = new JSONObject();
		JSONArray  buttons = new JSONArray();
		JSONArray  elements = new JSONArray();
		JSONObject default_action      = new JSONObject();
		JSONObject button;
		button = new JSONObject();
	       try {
	    	   if(type.toUpperCase().equals(Accesstokens.START)){
	    	   button.put("type"     , "postback");
	    	   button.put("title"        , "About My Dream" );
	    	   button.put("payload"           , "ABOUT_DREAM");
	    	   buttons.put(button);
	    	   button = new JSONObject();
	    	   button.put("type"     , "postback");
	    	   button.put("title"        , "Talk Me Through" );
	    	   button.put("payload"           , "TALK_ME");
	    	   buttons.put(button);

	    	   button = new JSONObject();
	    	   button.put("type"     , "web_url");
	    	   button.put("title"        , "NetBanking" );
	    	   button.put("url"           , "https://www.abnamro.nl/nl/en/personal/internet-and-mobile/internet-banking/index.html");
	    	   buttons.put(button);

	    	   
	    	   payload.put("buttons", buttons);
	    	   payload.put("template_type", "button");
	    	   payload.put("text", "What do you want to do next?");
	    	   
	    	   attachment.put("payload", payload);
	    	   attachment.put("type", "template");
	    	   
	    	   message.put("attachment", attachment);
	    	   json.put("message", message);
	    	   
	    	   recipient.put("id",((JsonMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
				json.put("recipient", recipient);
	       } else if(type.toUpperCase().equals(Accesstokens.TALK_ME)){
	    	   
	    	   button.put("type"     , "postback");
	    	   button.put("title"        , "Retirement" );
	    	   button.put("payload"           , "RETIREMENT");
	    	   buttons.put(button);
	    	   button = new JSONObject();
	    	   button.put("type"     , "postback");
	    	   button.put("title"        , "Solar Panels" );
	    	   button.put("payload"           , "PANELS");
	    	   buttons.put(button);

	    	   payload.put("buttons", buttons);
	    	   payload.put("template_type", "button");
	    	   payload.put("text", "What do you want to do with savings?");
	    	   
	    	   attachment.put("payload", payload);
	    	   attachment.put("type", "template");
	    	   
	    	   message.put("attachment", attachment);
	    	   json.put("message", message);
	    	   
	    	   recipient.put("id",((GetStartedMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
				json.put("recipient", recipient);
	    	   
	       }else if(type.toUpperCase().equals(Accesstokens.PANELS) || type.toUpperCase().equals(Accesstokens.POSTCODE)){
	    	  	if(type.toUpperCase().equals(Accesstokens.POSTCODE)){
	    	  		message.put("text", "If you add 30€ then you'll save 500€ after 10 months");
	    	  		recipient.put("id", ((JsonMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());

	 	    	  /* button.put("type"     , "web_url");
	 	    	   button.put("title"        , "View Website" );
	 	    	   button.put("url"           , "https://www.essent.nl/content/particulier/index.html#");
	 	    	   buttons.put(button);
	 	    	   button = new JSONObject();
	 	    	   button.put("type"     , "postback");
	 	    	   button.put("title"        , "Start Chatting" );
	 	    	   button.put("payload"           , "CHAT_BACK");
	 	    	   buttons.put(button);
	 	    	   
	 	    	   default_action.put("type", "web_url");
	 	    	  default_action.put("url", "https://www.essent.nl/content/particulier/index.html#");
	 	    	 default_action.put("messenger_extensions", "true");
	 	    	default_action.put("webview_height_ratio", "tall");  
	 	    	default_action.put("fallback_url", "https://www.essent.nl/content/particulier/index.html#");
	 	    	
	 	    	
	 	    	temp.put("title", "Know your Savings");
	 	    	temp.put("image_url", "http://deklantenservice.nl/wp-content/uploads/2013/02/essent.jpg");
	 	    	temp.put("subtitle", "With solar panels");
	 	    	 temp.put("default_action", default_action);
	 	    	 temp.put("buttons",buttons);
	 	    	  elements.put(temp); 
	 	    	//   payload.put("buttons", buttons);
	 	    	   payload.put("template_type", "generic");
	 	    	   payload.put("elements", elements);
	 	    	   
	 	    	   attachment.put("payload", payload);
	 	    	   attachment.put("type", "template");
	 	    	   
	 	    	   message.put("attachment", attachment);
	 	    	   json.put("message", message);
	 	    	   
	 	    	   recipient.put("id",((JsonMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
	 				json.put("recipient", recipient);*/
	 	       
					
	    	  	}else{
	    	  		message.put("text", "Enter the postcode to know the savings?");
	    	  		recipient.put("id", ((GetStartedMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
					
	    	  	}
	    	   
				
	    	  	
	    	 // 	recipient.put("id", ((GetStartedMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
				json.put("recipient", recipient);
				json.put("message", message);
				
	    	   
	       }else if(type.toUpperCase().equals(Accesstokens.ABOUT_DREAM)){

	    	  		message.put("text", "Whats your dream?");
	    	  		recipient.put("id", ((GetStartedMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
	    	 // 	recipient.put("id", ((GetStartedMessage) receivedMessage).getEntry().get(0).getMessaging().get(0).getSender().getId());
	    	  		json.put("recipient", recipient);
					json.put("message", message);
				
	    	   
	       }
	    	   
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return json.toString();
	}
	
	

}
