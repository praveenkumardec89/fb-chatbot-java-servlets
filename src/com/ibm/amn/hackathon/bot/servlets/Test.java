package com.ibm.amn.hackathon.bot.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.abn.hackathon.bot.beans.GetStartedMessage;
import com.ibm.abn.hackathon.bot.beans.JsonMessage;
import com.ibm.abn.hackathon.bot.beans.Postbackjsonmessage;
import com.ibm.abn.hackathon.bot.beans.Profile;
import com.ibm.abn.hackathon.bot.beans.ReadReceipt;
import com.ibm.abn.hackathon.bot.interfaces.Accesstokens;
import com.ibm.abn.hackathon.bot.utils.Connections;
//import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BufferedReader br = null;

    /**
     * Default constructor. 
     */
    public Test() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this part is for call back URL from messenger,
		//u should respond back with challenge back to continue
		String mytoken = request.getParameter("hub.verify_token");
		String challenge = request.getParameter("hub.challenge");
		if("test".equalsIgnoreCase(mytoken)){
			response.getWriter().append(challenge);
		}else{
		//this part is for other responses when test call is done.	
			String jsonToken = null;
			StringBuilder jsonString = new StringBuilder();
			 BufferedReader reader = request.getReader();
			 while ((jsonToken = reader.readLine()) != null){
			  jsonString.append(jsonToken);
			 } 
			 System.out.println(jsonString.toString());
			 Object receivedMessage = null;
			 GetStartedMessage getStartedMessage = null;
			 Connections c=null;
			 String builtMessage=null;
			 URL url=null;
			 OutputStream os=null;
		
		switch(checkTypeOfMessage(jsonString.toString())) {
		   case Accesstokens.GET_STARTED_PAYLOAD :
			   getStartedMessage =(GetStartedMessage) parse2(jsonString.toString(),  Accesstokens.GET_STARTED_PAYLOAD);
		      break; // optional
		   case Accesstokens.START :
			    receivedMessage= (JsonMessage) parse2(jsonString.toString(),Accesstokens.START);
			    c = new Connections();
			    builtMessage = c.buildIntialButtons((JsonMessage) receivedMessage, Accesstokens.START);
			    System.out.println(builtMessage);
				url = new URL(Accesstokens.url);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
			//	conn.setDoOutput(true);
			    os = conn.getOutputStream();
				os.write(builtMessage.getBytes());
				os.flush();
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			    break; // optional
			 
		   case Accesstokens.TALK_ME :
			    receivedMessage= (GetStartedMessage) parse2(jsonString.toString(),Accesstokens.TALK_ME);
			     c = new Connections();
			     builtMessage = c.buildIntialButtons(receivedMessage,Accesstokens.TALK_ME);
			    System.out.println(builtMessage);
				url = new URL(Accesstokens.url);
				conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
			//	conn.setDoOutput(true);
			    os = conn.getOutputStream();
				os.write(builtMessage.getBytes());
				os.flush();
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			    break; // optional
		   case Accesstokens.ABOUT_DREAM :
			    receivedMessage= (GetStartedMessage) parse2(jsonString.toString(),Accesstokens.ABOUT_DREAM);
			     c = new Connections();
			     builtMessage = c.buildIntialButtons(receivedMessage,Accesstokens.ABOUT_DREAM);
			    System.out.println(builtMessage);
				url = new URL(Accesstokens.url);
				conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
			//	conn.setDoOutput(true);
			    os = conn.getOutputStream();
				os.write(builtMessage.getBytes());
				os.flush();
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			    break; // optional
		   case Accesstokens.PANELS :
			    receivedMessage= (GetStartedMessage) parse2(jsonString.toString(),Accesstokens.TALK_ME);
			     c = new Connections();
			     builtMessage = c.buildIntialButtons(receivedMessage,Accesstokens.PANELS);
			    System.out.println(builtMessage);
				url = new URL(Accesstokens.url);
				conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
			//	conn.setDoOutput(true);
			    os = conn.getOutputStream();
				os.write(builtMessage.getBytes());
				os.flush();
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			    break; // optional   
		   case Accesstokens.POSTCODE :
			    receivedMessage= (JsonMessage) parse2(jsonString.toString(),Accesstokens.POSTCODE);
			    c = new Connections();
			    builtMessage = c.buildIntialButtons((JsonMessage) receivedMessage, Accesstokens.POSTCODE);
			    System.out.println(builtMessage);
				url = new URL(Accesstokens.url);
				conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
			//	conn.setDoOutput(true);
			    os = conn.getOutputStream();
				os.write(builtMessage.getBytes());
				os.flush();
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			    break; // optional  
			    
		   default : // Optional
		      // Statements
		}}
		//at this point you have read the message but haven't parsed
		// you can decide on which parser to use based on the text/content
		//	 System.out.println(" string"+jsonString);
			

			//build a JSON response and send back
			 
	/*		JSONObject json      = new JSONObject();//object created
			JSONObject recipient      = new JSONObject();
			JSONObject message      = new JSONObject();
			try {
				
				// post the message back to the user
				URL url = new URL(Accesstokens.url);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				
				// get the profile name of the user to respond back
				Connections co = new Connections();
				String lastname = co.getProfile(receivedMessage.getEntry().get(0).getMessaging().get(0).getSender().getId());
				message.put("text", "Hello there"+" "+lastname+"!! \nhow may I help you today?");
				recipient.put("id", receivedMessage.getEntry().get(0).getMessaging().get(0).getSender().getId());
				json.put("recipient", recipient);
				json.put("message", message);
				
				
				OutputStream os = conn.getOutputStream();
				os.write(json.toString().getBytes());
				os.flush();
				
				if (conn.getResponseCode() == 200) {
					
				}else{
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
				
				// read the post messages response 
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
				String output;
				System.out.println("Output from Server .... \n");
				String x= null;
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					
					
				}

				conn.disconnect();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			
			
			// response.setContentType("application/json");
		     //response.getWriter().write(json.toString()); 
			JSONArray  addresses = new JSONArray();
			JSONObject address;
			String i="";
			 address = new JSONObject();
		       try {
				address.put("CustomerName"     , "Decepticons" + i);
				  address.put("AccountId"        , "1999" + i);
			       address.put("SiteId"           , "1888" + i);
			       address.put("Number"            , "7" + i);
			       address.put("Building"          , "StarScream Skyscraper" + i);
			       address.put("Street"            , "Devestator Avenue" + i);
			       address.put("City"              , "Megatron City" + i);
			       address.put("ZipCode"          , "ZZ00 XX1" + i);
			       address.put("Country"           , "CyberTron" + i);
			       addresses.put(address);
			       json.put("Addresses", addresses);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		      
			 
 
		}*/

		
	}

	//to decide on the input type
	private String checkTypeOfMessage(String string) {
		 String type = "";
		if(string.contains("GET_STARTED_PAYLOAD")){
			type=Accesstokens.GET_STARTED_PAYLOAD;
		}else if(string.toLowerCase().contains("hi") || string.toLowerCase().contains("hello")){
			type=Accesstokens.START;
		}else if(string.contains("ABOUT_DREAM")){
			type=Accesstokens.ABOUT_DREAM;
		}else if(string.contains("TALK_ME")){
			type=Accesstokens.TALK_ME;
		}else if(string.contains("PANELS")){
			type=Accesstokens.PANELS;
		}else if(string.contains("1111") || string.contains("2222")){
			type=Accesstokens.POSTCODE;
		}else{
			
			
		}

		return type;
		
	}

	public Object parse2(String json, String type) throws JsonProcessingException, IOException  {
		   Connections c= new Connections();
		   Object messageinput = null;
		//   GetStartedMessage getStartedMessage = null;
	       ObjectMapper mapper = c.getJsonObjectMapper();
	       if(type.equalsIgnoreCase(Accesstokens.START) || type.equalsIgnoreCase(Accesstokens.POSTCODE) ){
	    	    messageinput = mapper.readValue(json, JsonMessage.class);//.readTree(json); 
		       System.out.println(((JsonMessage) messageinput).getEntry().get(0).getMessaging().get(0).getMessage().getText());
		      
	       }else if(type.equalsIgnoreCase(Accesstokens.GET_STARTED_PAYLOAD)){
	    	   messageinput = mapper.readValue(json, GetStartedMessage.class);//.readTree(json); 
		 //      System.out.println(messageinput.getEntry().get(0).getMessaging().get(0).getMessage().getText());
	   
	       }else if(type.equalsIgnoreCase(Accesstokens.TALK_ME) || type.equalsIgnoreCase(Accesstokens.ABOUT_DREAM)){
	    	   messageinput = mapper.readValue(json, GetStartedMessage.class);//.readTree(json); 
		  }   
	        return messageinput;
	       //testing
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
