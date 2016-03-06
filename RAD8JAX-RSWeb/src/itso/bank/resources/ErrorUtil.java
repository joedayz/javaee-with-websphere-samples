package itso.bank.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

public class ErrorUtil {
	public static JSONObject errorObject(String msg){
		JSONObject object = new  JSONObject();
		object.put("error", msg);
		return object;

	}
	public static JSONArray errorArray(String msg){
		JSONObject object = errorObject(msg);
		JSONArray array = new JSONArray();
		array.add(object);
		return array;

	}
	
	public static Response jSONObjectResponse(Status status, String msg){
  return Response.status(Status.BAD_REQUEST).type("application/json").entity(errorObject(msg)).build();

	}
 public static Response jSONArrayResponse(Status status, String msg){
  return Response.status(Status.BAD_REQUEST).type("application/json").entity(errorArray(msg)).build();

 }

}
