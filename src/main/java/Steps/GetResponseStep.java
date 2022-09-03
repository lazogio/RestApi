package Steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static Utils.Variable.EndPoints.UsersUrl;
import static io.restassured.RestAssured.given;

public class GetResponseStep {
    @Step
    public Response userStep() {

        Response response = given()
                            .filter(new AllureRestAssured())
                            .header("Content-Type","application/json")
                            .when()
                            .get(UsersUrl)
                            .then()
                            .and().extract()
                            .response();
        int statusCode = response.statusCode();
        if(statusCode == 200) {
            return response;
        } else {
            System.err.println("Response Status Code: " + statusCode);
        }

        return null;
    }
}
