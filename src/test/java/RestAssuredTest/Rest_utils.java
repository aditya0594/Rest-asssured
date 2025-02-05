package RestAssuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class Rest_utils {
	
	 /*"name": "Chandira Kaniyar VM",
    "email": "chandira_kaniyar_vm@kuhlman.org",
    "gender": "Male",
    "status": "Active"*/

	public static String getName() {
		String generaString = RandomStringUtils.randomAlphabetic(1);
		return("adi"+generaString);
	}
	public static String getEmail() {
		String generaString = RandomStringUtils.randomAlphabetic(4);
		return("adi"+generaString+"@gmail.com");
		
	}
	public static String getGender() {
		
		return("Male");
		
	}
    public static String getStatus() {
		
		return("Active");
		
	}
	
	
}
