package Stepdefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@deleteplace")
    public void beforScenario() throws IOException {
       // StepDefinationFile stepfile = new StepDefinationFile();  old
      /*  if(stepfile.place_id == null) {
          //  stepfile.add_place_payload("hooksname", "HooksAddress");
           // stepfile.user_call_with_http_request("AddPlaceAPI", "POST");
           // stepfile.verify_the_place_id_created_maps_to_using("hooksname", "GetPlaceAPI");
        }
*/
    }
}
