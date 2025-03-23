package pojo;

import java.util.List;

public class Project {
    private String project_name;
    private String project_description;
    private int master_project_type_id;
    private int master_project_category_id;
    private String location;
    private double latitude;
    private double longitude;
    private int master_country_id;
    private int bid_expiry_day;
    private int master_agreement_type_id;
    private int cost_sharing;
    private int master_cost_sharing_unit_id;
    private int average_monthly_payment;
    private int amp_master_currency_id;
    private Integer leasing_tariff;
    private int lt_master_currency_id;
    private int project_capacity;
    private int master_capacity_unit_id;
    private int tenure_length;
    private int tenure_age;
    private int master_module_specification_id;
    private String module_brand;
    private int master_grid_connection_id;
    private int current_tenancy_age;
    private String mounting_system;
    private String installation_date;
    private String generation_data;
    private int generation_data_unit;
    private boolean maintenance_covered_under;
    private String temporary_occupation_permit_date;
    private int avg_system_eff;
    private String avg_system_eff_unit;
    private int degeneration_rate;
    private int sell_budget;
    private int sbu_master_currency_id;
    private String addon_feature;
    private String video_url;
    private List<ProjectImage> project_images;
    private List<Object> project_documents;

    // Getters and Setters
    public String getProject_name() { return project_name; }
    public void setProject_name(String project_name) { this.project_name = project_name; }

    public String getProject_description() { return project_description; }
    public void setProject_description(String project_description) { this.project_description = project_description; }

    public int getMaster_project_type_id() { return master_project_type_id; }
    public void setMaster_project_type_id(int master_project_type_id) { this.master_project_type_id = master_project_type_id; }

    public int getMaster_project_category_id() { return master_project_category_id; }
    public void setMaster_project_category_id(int master_project_category_id) { this.master_project_category_id = master_project_category_id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getMaster_country_id() { return master_country_id; }
    public void setMaster_country_id(int master_country_id) { this.master_country_id = master_country_id; }

    public int getBid_expiry_day() { return bid_expiry_day; }
    public void setBid_expiry_day(int bid_expiry_day) { this.bid_expiry_day = bid_expiry_day; }

    public int getMaster_agreement_type_id() { return master_agreement_type_id; }
    public void setMaster_agreement_type_id(int master_agreement_type_id) { this.master_agreement_type_id = master_agreement_type_id; }

    public int getCost_sharing() { return cost_sharing; }
    public void setCost_sharing(int cost_sharing) { this.cost_sharing = cost_sharing; }

    public int getMaster_cost_sharing_unit_id() { return master_cost_sharing_unit_id; }
    public void setMaster_cost_sharing_unit_id(int master_cost_sharing_unit_id) { this.master_cost_sharing_unit_id = master_cost_sharing_unit_id; }

    public int getAverage_monthly_payment() { return average_monthly_payment; }
    public void setAverage_monthly_payment(int average_monthly_payment) { this.average_monthly_payment = average_monthly_payment; }

    public int getAmp_master_currency_id() { return amp_master_currency_id; }
    public void setAmp_master_currency_id(int amp_master_currency_id) { this.amp_master_currency_id = amp_master_currency_id; }

    public Integer getLeasing_tariff() { return leasing_tariff; }
    public void setLeasing_tariff(Integer leasing_tariff) { this.leasing_tariff = leasing_tariff; }

    public int getLt_master_currency_id() { return lt_master_currency_id; }
    public void setLt_master_currency_id(int lt_master_currency_id) { this.lt_master_currency_id = lt_master_currency_id; }

    public int getProject_capacity() { return project_capacity; }
    public void setProject_capacity(int project_capacity) { this.project_capacity = project_capacity; }

    public int getMaster_capacity_unit_id() { return master_capacity_unit_id; }
    public void setMaster_capacity_unit_id(int master_capacity_unit_id) { this.master_capacity_unit_id = master_capacity_unit_id; }

    public int getTenure_length() { return tenure_length; }
    public void setTenure_length(int tenure_length) { this.tenure_length = tenure_length; }

    public int getTenure_age() { return tenure_age; }
    public void setTenure_age(int tenure_age) { this.tenure_age = tenure_age; }

    public int getMaster_module_specification_id() { return master_module_specification_id; }
    public void setMaster_module_specification_id(int master_module_specification_id) { this.master_module_specification_id = master_module_specification_id; }

    public String getModule_brand() { return module_brand; }
    public void setModule_brand(String module_brand) { this.module_brand = module_brand; }

    public int getMaster_grid_connection_id() { return master_grid_connection_id; }
    public void setMaster_grid_connection_id(int master_grid_connection_id) { this.master_grid_connection_id = master_grid_connection_id; }

    public int getCurrent_tenancy_age() { return current_tenancy_age; }
    public void setCurrent_tenancy_age(int current_tenancy_age) { this.current_tenancy_age = current_tenancy_age; }

    public String getMounting_system() { return mounting_system; }
    public void setMounting_system(String mounting_system) { this.mounting_system = mounting_system; }

    public String getInstallation_date() { return installation_date; }
    public void setInstallation_date(String installation_date) { this.installation_date = installation_date; }

    public List<ProjectImage> getProject_images() { return project_images; }
    public void setProject_images(List<ProjectImage> project_images) { this.project_images = project_images; }

    public List<Object> getProject_documents() { return project_documents; }
    public void setProject_documents(List<Object> project_documents) { this.project_documents = project_documents; }
    public String getGeneration_data() {
        return generation_data;
    }

    public void setGeneration_data(String generation_data) {
        this.generation_data = generation_data;
    }

    public int getGeneration_data_unit() {
        return generation_data_unit;
    }

    public void setGeneration_data_unit(int generation_data_unit) {
        this.generation_data_unit = generation_data_unit;
    }

    public boolean isMaintenance_covered_under() {
        return maintenance_covered_under;
    }

    public void setMaintenance_covered_under(boolean maintenance_covered_under) {
        this.maintenance_covered_under = maintenance_covered_under;
    }

    public String getTemporary_occupation_permit_date() {
        return temporary_occupation_permit_date;
    }

    public void setTemporary_occupation_permit_date(String temporary_occupation_permit_date) {
        this.temporary_occupation_permit_date = temporary_occupation_permit_date;
    }

    public int getAvg_system_eff() {
        return avg_system_eff;
    }

    public void setAvg_system_eff(int avg_system_eff) {
        this.avg_system_eff = avg_system_eff;
    }

    public String getAvg_system_eff_unit() {
        return avg_system_eff_unit;
    }

    public void setAvg_system_eff_unit(String avg_system_eff_unit) {
        this.avg_system_eff_unit = avg_system_eff_unit;
    }

    public int getDegeneration_rate() {
        return degeneration_rate;
    }

    public void setDegeneration_rate(int degeneration_rate) {
        this.degeneration_rate = degeneration_rate;
    }

    public int getSell_budget() {
        return sell_budget;
    }

    public void setSell_budget(int sell_budget) {
        this.sell_budget = sell_budget;
    }

    public int getSbu_master_currency_id() {
        return sbu_master_currency_id;
    }

    public void setSbu_master_currency_id(int sbu_master_currency_id) {
        this.sbu_master_currency_id = sbu_master_currency_id;
    }

    public String getAddon_feature() {
        return addon_feature;
    }

    public void setAddon_feature(String addon_feature) {
        this.addon_feature = addon_feature;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    // Inner class for ProjectImage
    public static class ProjectImage {
        private String attachment;
        private String attachment_title;
        private String extension;
        private boolean is_thumbnail;

        public ProjectImage(String img_base64, String s, String png, boolean b) {
        }


        public String getAttachment() { return attachment; }
        public void setAttachment(String attachment) { this.attachment = attachment; }

        public String getAttachment_title() { return attachment_title; }
        public void setAttachment_title(String attachment_title) { this.attachment_title = attachment_title; }

        public String getExtension() { return extension; }
        public void setExtension(String extension) { this.extension = extension; }

        public boolean is_thumbnail() { return is_thumbnail; }
        public void setIs_thumbnail(boolean is_thumbnail) { this.is_thumbnail = is_thumbnail; }
    }
}
