package APIClient;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseClient {

    // No trailing slash here; paths below start with '/'
    protected static final String BASE_URL       = System.getProperty("BASE_URL", "http://62.113.102.24");
    protected static final String RESTAPI_PREFIX = System.getProperty("RESTAPI_PREFIX", "/restapi/v2");
    protected static final String INSIDER_PREFIX = System.getProperty("INSIDER_PREFIX", "/insider/v2");

    static {
        RestAssured.baseURI = BASE_URL;
    }

    protected static RequestSpecification base() {
        return given()
                .baseUri(BASE_URL)
                // ignore untrusted certs if you switch to https://
                .relaxedHTTPSValidation()
                .config(RestAssuredConfig.config()
                        .sslConfig(new SSLConfig().relaxedHTTPSValidation().allowAllHostnames()))
                .accept(ContentType.JSON)
                // handy when a test fails:
                .log().ifValidationFails();
    }

    protected static RequestSpecification auth(String token) {
        return base()
                .header("Authorization", "Bearer " + token);
    }

    // Helpers for consistent path building
    protected static String restapi(String path) {
        return RESTAPI_PREFIX + path; // e.g. "/restapi/v2" + "/organizations/.."
    }

    protected static String insider(String path) {
        return INSIDER_PREFIX + path; // e.g. "/insider/v2" + "/node_by_name"
    }
}
