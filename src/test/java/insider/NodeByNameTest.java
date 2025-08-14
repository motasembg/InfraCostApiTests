package insider;

import APIClient.InsiderClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NodeByNameTest {

    private final String token = "PASTE_YOUR_BEARER_TOKEN";
    private final String cloudAccountId = "PASTE_CLOUD_ACCOUNT_ID";
    private final String nodeName = "PASTE_NODE_NAME";

    @Test
    void returns200AndExactName() {
        Response r = InsiderClient.nodeByName(token, cloudAccountId, nodeName);
        assertEquals(200, r.statusCode(), "Expected 200 OK");

        JsonPath jp = r.jsonPath();
        assertEquals(nodeName, jp.getString("name"), "Expected node name to match");
    }

    @Test
    void missingCloudAccountId_is400() {
        Response r = InsiderClient.nodeByName(token, "", nodeName);
        assertEquals(400, r.statusCode(), "Expected 400 for missing cloud_account_id");
    }

    @Test
    void unknownNode_is404() {
        Response r = InsiderClient.nodeByName(token, cloudAccountId, "___not_existing___");
        assertEquals(404, r.statusCode(), "Expected 404 for unknown node");
    }
}
