package statistics;

import APIClient.InsiderClient;
import APIClient.StatisticsClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class Org {
    private final String token = "MDAwZWxvY2F0aW9uIAowMDM0aWRlbnRpZmllciBiNDFkMDM4MC1lOWMwLTQ5YTgtODI3Mi1kMDM1MjBmNzU0MjcKMDAyM2NpZCBjcmVhdGVkOjE3NTU0MzUyMTAuNzgxNjQ5NgowMDE3Y2lkIHJlZ2lzdGVyOkZhbHNlCjAwMWFjaWQgcHJvdmlkZXI6b3B0c2NhbGUKMDAyZnNpZ25hdHVyZSBE8QSwoxlTTWSCobQEkiX0FM_tw59iHl8La0WddLD7oQo";

    @Test
    void justForTest() {
        Response r = StatisticsClient.justForTest(token);
        assertEquals(200, r.statusCode(), "Expected 200 OK");

//        JsonPath jp = r.jsonPath();
//        assertEquals(nodeName, jp.getString("name"), "Expected node name to match");
    }
}
