package Resources;

public enum APIResources {

    //enum is th special class in the java which has a collection of constants and methods
     AddPlaceAPI("/maps/api/place/add/json"),
    DeletePlaceAPI("/maps/api/place/delete/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    SentOTP("/user/send-otp");
    private String resource;
     APIResources(String resource){
            this.resource= resource;
     }

     public String getResource(){
         return resource;
     }

}
