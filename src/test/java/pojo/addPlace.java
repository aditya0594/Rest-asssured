package pojo;

import java.util.Collections;
import java.util.List;

public class addPlace {

    private location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> type;

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }


    private String website;
    private String language;


    public void setLocation(location location) {
        this.location = location;
    }
    public location getLocation() {
        return location;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public int getAccuracy() {
        return accuracy;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }



    public void setWebsite(String website) {
        this.website = website;
    }
    public String getWebsite() {
        return website;
    }


    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }


}
