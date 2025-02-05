package Resources;

import pojo.SentOTP;
import pojo.addPlace;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class TestDataFields {
    public addPlace addplacePayload(String name,String address){
        addPlace p = new addPlace();
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress(address);
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");

        //type list which is the array
        List<String> listType = new ArrayList<>();
        listType.add("shoe park");
        listType.add("shop");
        p.setType(listType);

        // for the location which contains the class first we have to create the object to access then we have to use that
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }
    public String deleteplacePayload(String placeID){
        return "{\r\n    \"place_id\": \""+placeID+"\"\r\n}";
    }
    public SentOTP email_address(String consumerEmail){
        SentOTP emailotp = new SentOTP();
        emailotp.setEmail_address(consumerEmail);
        return emailotp;
    }

}
