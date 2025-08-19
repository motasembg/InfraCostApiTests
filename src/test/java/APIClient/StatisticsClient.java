package APIClient;

import io.restassured.response.Response;

public class StatisticsClient extends BaseClient {

    /** GET /restapi/v2/organizations/{org}/total_home_statistics/{period} */
    public static Response totalHomeStatistics(String token, String orgId, String period) {
        return auth(token)
                .when()
                .get(restapi("/organizations/{org}/total_home_statistics/{period}"), orgId, period);
    }

    /** GET /restapi/v2/organizations/{org}/pie_chart_statistics/{period} */
    public static Response pieChartStatistics(String token, String orgId, String period) {
        return auth(token)
                .when()
                .get(restapi("/organizations/{org}/pie_chart_statistics/{period}"), orgId, period);
    }
    public static Response justForTest(String token) {
        return auth(token)
                .when()
                .get(restapi("/organizations"));
    }


}
