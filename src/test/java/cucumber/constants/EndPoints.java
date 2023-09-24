package cucumber.constants;

public enum EndPoints {

    STORE("/store");

    public final String url;

    EndPoints(String url){
        this.url=url;
    }
}
