package starter.nace.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class TestGetNACEResponse {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static WireMockServer wireMockServer = new WireMockServer(PORT);
    CloseableHttpClient httpClient = HttpClients.createDefault();
    @BeforeClass
    public static void setup() {
        RestAssured.defaultParser = Parser.JSON;
        wireMockServer.start();
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(200);
        mockResponse.withBody("{\"Level\": \"1\", \"Code\": \"A\", \"Parent\": \"\", \"Description\": \"AGRICULTURE, FORESTRY AND FISHING\", \"This_item_includes\": \"AGRICULTURE, FORESTRY AND FISHING\tThis section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.\", \"This_item_also_includes\": \"\", \"Rulings\": \"\", \"This_item_excludes\": \"\", \"Reference_to_ISIC_Rev_4\": \"A\"}");
        WireMock.configureFor(HOST, PORT);
        WireMock.stubFor(
                WireMock.get("/nacedetails/398481")
                        .willReturn(mockResponse)
        );
    }

    @Test
    public void testGetNACEEndpoint() throws URISyntaxException {
        RestAssured.given()
                .when()
                .get(new URI("http://localhost:8080/nacedetails/398481"))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterClass
    public static void tearDown() {
        if(null != wireMockServer && wireMockServer.isRunning()) {
            wireMockServer.shutdown();
        }
    }
}
