package APIClient;

import io.restassured.response.Response;

public class InsiderClient extends BaseClient {

    /** GET /insider/node_by_name?cloud_account_id=...&name=... */
    public static Response nodeByName(String token, String cloudAccountId, String name) {
        return auth(token)
                .queryParam("cloud_account_id", cloudAccountId)
                .queryParam("name", name)
                .when()
                .get(insider("/node_by_name"));
    }
}
