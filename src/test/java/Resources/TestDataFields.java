package Resources;

import pojo.BuySell;
import pojo.addPlace;
import pojo.location;
import pojo.sent_otp;

import java.util.ArrayList;
import java.util.List;

import static Resources.Utils.readExcel;

public class TestDataFields {
    public addPlace addplacePayload(String name, String address) {
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

    public String deleteplacePayload(String placeID) {
        return "{\r\n    \"place_id\": \"" + placeID + "\"\r\n}";
    }

    public sent_otp email_address(String consumerEmail) {
        sent_otp emailotp = new sent_otp();
        emailotp.email_address(consumerEmail);
        return emailotp;
    }

    public BuySell buysellpayload(String Projectname) {
        String Image = readExcel("ImagePdf", 1, 0);
        BuySell p = new BuySell();

        p.setProject_name(Projectname);
        p.setProject_description("");
        p.setMaster_project_type_id(1);
        p.setMaster_project_category_id(2);
        p.setLocation("Chatrapati Square, Sawarkar Nagar, Vivekanand Nagar, Nagpur, Maharashtra");
        p.setLatitude(21.1107592);
        p.setLongitude(79.07008859999999);
        p.setMaster_country_id(103);
        p.setBid_expiry_day(90);
        p.setMaster_agreement_type_id(1);
        p.setCost_sharing(100);
        p.setMaster_cost_sharing_unit_id(125);
        p.setAverage_monthly_payment(1);
        p.setAmp_master_currency_id(125);
        p.setLeasing_tariff(null); // or set a value if known
        p.setLt_master_currency_id(125);
        p.setProject_capacity(1000);
        p.setMaster_capacity_unit_id(2);
        p.setTenure_length(1);
        p.setTenure_age(1);
        p.setMaster_module_specification_id(5);
        p.setModule_brand("brand");
        p.setMaster_grid_connection_id(3);
        p.setCurrent_tenancy_age(100);
        p.setMounting_system("Mounting System");
        p.setInstallation_date("2025-03-05");
        p.setGeneration_data("");
        p.setGeneration_data_unit(2);
        p.setMaintenance_covered_under(true);
        p.setTemporary_occupation_permit_date("2025-03-04");
        p.setAvg_system_eff(10);
        p.setAvg_system_eff_unit("%");
        p.setDegeneration_rate(1);
        p.setSell_budget(150000);
        p.setSbu_master_currency_id(125);
        p.setAddon_feature("");
        p.setVideo_url("https://www.youtube.com/watch?v=Xf0yP-kNyXQ");

// Setting project images
        List<BuySell.ProjectImage> images = new ArrayList<>();

        BuySell.ProjectImage img1 = new BuySell.ProjectImage();
        img1.setAttachment(Image);
        img1.setAttachment_title("IMG 1.png");
        img1.setExtension("png");
        img1.setIs_thumbnail(true);

        BuySell.ProjectImage img2 = new BuySell.ProjectImage();
        img2.setAttachment(Image);
        img2.setAttachment_title("IMG 2.png");
        img2.setExtension("png");
        img2.setIs_thumbnail(false);

        BuySell.ProjectImage img3 = new BuySell.ProjectImage();
        img3.setAttachment(Image);
        img3.setAttachment_title("IMG 3.png");
        img3.setExtension("png");
        img3.setIs_thumbnail(false);

        BuySell.ProjectImage img5 = new BuySell.ProjectImage();
        img5.setAttachment(Image);
        img5.setAttachment_title("IMG 5.png");
        img5.setExtension("png");
        img5.setIs_thumbnail(false);

        images.add(img1);
        images.add(img2);
        images.add(img3);
        images.add(img5);

        p.setProject_images(images);

// If you have documents to add
        p.setProject_documents(new ArrayList<>());
        return p;
    }
}

