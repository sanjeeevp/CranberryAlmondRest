package com.cranberry.almond.restClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PersonRestClient {
	public static void main(String[] args) {
		 
		PersonRestClient crunchifyClient = new PersonRestClient();
		crunchifyClient.getFtoCResponse();
	}
 
	private void getFtoCResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource2 = client.resource("http://localhost:8090/CranberryAlmondREST/persons/Info/all");
			ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			String output2 = response2.getEntity(String.class);
			System.out.println("\n============getFtoCResponse============");
			System.out.println(output2);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
