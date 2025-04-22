package Stepdefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@otp")
    public void beforScenario() throws IOException {
        StepDefinationFile stepfile = new StepDefinationFile();
        if(stepfile.place_id == null) {
            stepfile.consumer_user_send_and_verify_otp();
            stepfile.get_the_logintoken_from_the_response();
        }

    }
}
