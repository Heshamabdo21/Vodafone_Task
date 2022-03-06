package tests.gui.YouTube;

import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;
import com.shaft.validation.Verifications;

import io.restassured.response.Response;

public class APITest {

	@Test
    public void validateUserEmail() {
	RestActions apiObject = new RestActions("https://jsonplaceholder.typicode.com");
	Response users = apiObject.performRequest(RequestType.GET, 200, "/users");
	int min = 1;  
	int max = 100;  
	int userid = (int)(Math.random()*(max-min+1)+min);  
String user_id=String.valueOf(userid);
	//Assertions.assertEquals("Leanne Graham", RestActions.getResponseBody(users), AssertionComparisonType.CONTAINS,
	//	AssertionType.POSITIVE);

	RestActions.getResponseJSONValueAsList(users, "$").forEach(user -> {
		if(RestActions.getResponseJSONValue(user, "id") == user_id) {
		System.out.println(RestActions.getResponseJSONValue(user, "email"));
		}
	    }

	);


	
    }
    
    

}
