package starter.nace;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetNACEAPI {

    private static String NACE_DETAILS_BY_ORDER_ID = "http://api.debank.de/nacedetails/{order_id}";

    @Step("I fetch nace details for order {int}")
    public void fetchNACEDetailsByOrderId(int order_id) {
    SerenityRest.given()
                .pathParam("order_id", order_id)
                .get(NACE_DETAILS_BY_ORDER_ID);
    }
}
