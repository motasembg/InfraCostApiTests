package APIClient;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseClient {

    // Set via -D props; sensible defaults for local/dev
    protected static final String BASE_URL        = System.getProperty("BASE_URL", "https://158.160.190.231");
    protected static final String RESTAPI_PREFIX  = System.getProperty("RESTAPI_PREFIX", "/restapi/v2");
    protected static final String INSIDER_PREFIX  = System.getProperty("INSIDER_PREFIX", "/insider/v2"); // or /insider/v2

    static {
        RestAssured.baseURI = BASE_URL; // keep RestAssured happy if someone uses absolute paths later
    }

    protected static RequestSpecification base() {
        return given()
                .baseUri(BASE_URL)
                .accept(ContentType.JSON);
    }

    protected static RequestSpecification auth(String token) {
        return base()
                .header("Authorization", "Bearer " + token);
    }

    // Helpers to build full paths consistently
    protected static String restapi(String path) {
        return RESTAPI_PREFIX + path;
    }

    protected static String insider(String path) {
        return INSIDER_PREFIX + path;
    }
}
