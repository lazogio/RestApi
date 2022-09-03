package Utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class GetJsonPathValue {
    @Step
    public GetJsonPathValue GetJson(Response response, String Path) {
        response.body().jsonPath().get(Path);
        return this;
    }
}
