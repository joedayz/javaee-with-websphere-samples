package itso.bank.jaxrs.client;

import java.io.IOException;

import org.apache.wink.client.ClientResponse;

import com.ibm.json.java.JSONArray;

public class GetAllCustomersClient {

	private org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
	private org.apache.wink.client.RestClient client = new org.apache.wink.client.RestClient(clientConfig);
	private final String base = "http://localhost:9080/RAD8JAX-RSWeb/jaxrs";

	public static void main(String args[]) throws IOException {
		GetAllCustomersClient getAllCustomersClient = new GetAllCustomersClient();
		getAllCustomersClient.getResource(getAllCustomersClient.base + "/customers");

	}

	public JSONArray getResource(String URI) {
		org.apache.wink.client.Resource resource = client.resource(URI);
		ClientResponse response = resource.get();
		System.out.println("Getting: " + URI);
		System.out.println("Received Message:\n" + response.getMessage());
		System.out.println("Received Entity:\n" + response.getEntity(JSONArray.class));
		return response.getEntity(JSONArray.class);
	}
}
