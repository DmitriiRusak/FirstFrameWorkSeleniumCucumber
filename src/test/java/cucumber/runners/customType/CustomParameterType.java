package cucumber.runners.customType;

import io.cucumber.java.ParameterType;
import cucumber.domainObjects.Product;

public class CustomParameterType {

    @ParameterType(".*")     //<--match everithing
    public Product product(String name){
        return new Product(name.replace("\"", ""));
    }

}
