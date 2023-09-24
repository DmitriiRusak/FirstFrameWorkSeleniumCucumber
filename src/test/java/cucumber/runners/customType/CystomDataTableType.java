package cucumber.runners.customType;

import io.cucumber.java.DataTableType;
import cucumber.domainObjects.BillingDitails;

import java.util.Map;

public class CystomDataTableType {

    @DataTableType
    public BillingDitails billingDitailsInit(Map<String,String> map){
        return new BillingDitails(map.get("First name"),
                                    map.get("Last name"),
                                    map.get("Country"),
                                    map.get("Street address"),
                                    map.get("Town"),
                                    map.get("Department"),
                                    map.get("Email address"));
    }
}
