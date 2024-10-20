package POJO;

import java.util.List;

public class POJO_Course {

    private List<WebAutomation> webAutomation;
    private List<API> api;
    private List<mobile> mobile;

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }


    public void setApi(List<API> api) {
        this.api = api;
    }
    public List<API> getApi() {
        return api;
    }


    public void setMobile(List<POJO.mobile> mobile) {
        this.mobile = mobile;
    }
    public List<POJO.mobile> getMobile() {
        return mobile;
    }











}
