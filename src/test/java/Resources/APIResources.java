package Resources;

public enum APIResources {

    //enum is th special class in the java which has a collection of constants and methods
     AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json");

     private String resource;
     APIResources(String resource){
            this.resource= resource;
     }

     public String getResource(){
         return resource;
     }
}
