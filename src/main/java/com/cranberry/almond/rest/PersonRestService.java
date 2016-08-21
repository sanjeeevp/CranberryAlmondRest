package com.cranberry.almond.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.cranberry.almond.Criteria.Person;
import com.cranberry.almond.service.PersonService;

 
@Path("Info")
public class PersonRestService {

	@GET
	@Path("/all")
	@Produces("application/json")
	 public Response getPersonInfo() throws JSONException {
		
		System.out.println("The application is running...");
		
		List<JSONObject> joList = new ArrayList<>();
		
		List<Person> pList = PersonService.getList();
		JSONObject jsonObject = null;;
		for(Person p : pList){
			jsonObject = new JSONObject();
			
			jsonObject.put("phoneNumber", p.getPhoneNum());
			jsonObject.put("fName", p.getfName());
			jsonObject.put("lName", p.getlName());
			jsonObject.put("city", p.getCity());
			
			joList.add(jsonObject);
			
		}
		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}

	
}
