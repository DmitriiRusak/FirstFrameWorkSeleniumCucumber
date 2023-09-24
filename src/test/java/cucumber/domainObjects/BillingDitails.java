package cucumber.domainObjects;

public class BillingDitails {

    private String first_name;
    private String last_name;
    private String country;
    private String street_address;
    private String town;
    private String department;
    private String email_address;

    public BillingDitails(String first_name, String last_name,
                          String country, String street_address,
                          String town, String department, String email_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.country = country;
        this.street_address = street_address;
        this.town = town;
        this.department = department;
        this.email_address = email_address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
