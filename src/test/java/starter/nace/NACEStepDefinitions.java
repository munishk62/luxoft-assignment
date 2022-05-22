package starter.nace;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Description;
import starter.nace.GetNACEAPI;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NACEStepDefinitions {

    @Steps
    GetNACEAPI getNACEAPI;

    @When("I fetch nace details for order {int}")
    public void i_fetch_nace_details_for_order(Integer order_id) {
        getNACEAPI.fetchNACEDetailsByOrderId(order_id);
    }
    @Then("response.Body should be valid json")
    public void response_body_should_be_valid_json() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Then("response.Level should be {string}")
    public void response_level_should_be(String Level) {
        restAssuredThat(response -> response.body(NACEResponse.LEVEL, equalTo(Level)));
    }
    @Then("response.Code should be {string}")
    public void response_code_should_be(String Code) {
        restAssuredThat(response -> response.body(NACEResponse.CODE, equalTo(Code)));
    }
    @Then("response.Parent should be null")
    public void response_parent_should_be_null() {
        restAssuredThat(response -> response.body(null));
    }
    @Then("response.Description should be {string}")
    public void response_description_should_be(String  Description) {
        restAssuredThat(response -> response.body(NACEResponse.DESCRIPTION, equalTo(Description)));
    }
    @Then("response.This_item_includes should be {string}")
    public void response_this_item_includes_should_be(String thisItemIncludes) {
        restAssuredThat(response -> response.body(NACEResponse.THIS_ITEM_INCLUDES, equalTo(thisItemIncludes)));
    }
    @Then("response.This_item_also_includes should be null")
    public void response_this_item_also_includes_should_be_null() {
        restAssuredThat(response -> response.body(null));
    }
    @Then("response.Rulings should null")
    public void response_rulings_should_null() {
        restAssuredThat(response -> response.body(null));
    }
    @Then("response.This_item_excludes should be null")
    public void response_this_item_excludes_should_be_null() {
        restAssuredThat(response -> response.body(null));
    }
    @Then("response.Reference_to_ISIC_Rev_{int} should be {string}")
    public void response_reference_to_isic_rev_should_be(String referenceToIISCRev) {
        restAssuredThat(response -> response.body(NACEResponse.REFERENCE_TO_ISIC_REV_4, equalTo(referenceToIISCRev)));

    }
}
