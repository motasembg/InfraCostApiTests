package statistics;

import APIClient.StatisticsClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TotalHomeStatisticsTest {

    // Paste your real values here
    private final String token = "PASTE_YOUR_BEARER_TOKEN";
    private final String orgId = "PASTE_ORGANIZATION_ID";
    private final String period = "2025-07";

    @Test
    void returns200AndNonEmptyBody() {
        Response r = StatisticsClient.totalHomeStatistics(token, orgId, period);
        assertEquals(200, r.statusCode(), "Expected 200 OK");

        JsonPath jp = r.jsonPath();
        assertNotNull(jp.getMap("$"), "Expected response body to have fields");
    }

    @Test
    void badPeriod_is4xx() {
        Response r = StatisticsClient.totalHomeStatistics(token, orgId, "bad-period");
        int status = r.statusCode();
        boolean is4xx = status == 400 || status == 404;
        assertEquals(true, is4xx, "Expected status 400 or 404 but got " + status);
    }
}
