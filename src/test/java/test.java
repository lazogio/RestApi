import Models.DataItem;
import Models.UserDataModel;
import Steps.GetResponseStep;
import Steps.ValidationResponse;
import Utils.expectedResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class test {
    GetResponseStep getResponseStep = new GetResponseStep();
    ValidationResponse validationResponse = new ValidationResponse();
    expectedResponse expectedResponse = new expectedResponse();

    @Test
    public void main(){

        Response response  = getResponseStep.userStep();
        UserDataModel userDataModel = response.as(UserDataModel.class);
        JsonPath path = response.body().jsonPath();

        validationResponse
                        .checkCode(userDataModel.getCode(),path.get(expectedResponse.code).toString())
                        .checkData(userDataModel.getData(),path.get(expectedResponse.data))
                        .checkMetaSize(userDataModel.getMeta().getPagination().getPage(),path.get(expectedResponse.page).toString())
                        .checkMetaSize(userDataModel.getMeta().getPagination().getLimit(),path.get(expectedResponse.limit).toString())
                        .checkMetaSize(userDataModel.getMeta().getPagination().getPages(),path.get(expectedResponse.pages).toString())
                        .checkMetaSize(userDataModel.getMeta().getPagination().getTotal(),path.get(expectedResponse.total).toString());

      for (var i=0;i<userDataModel.getData().size();i++){
            DataItem dataItem = userDataModel.getData().get(i);
            validationResponse
                            .checkId(dataItem.getId(), path.get(expectedResponse.id+"["+i+"]"))
                            .checkName(dataItem.getName(),path.get(expectedResponse.name+"["+i+"]"))
                            .checkEmail(dataItem.getEmail(),path.get(expectedResponse.email+"["+i+"]"))
                            .checkGender(dataItem.getGender(),path.get(expectedResponse.gender+"["+i+"]"))
                            .checkStatus(dataItem.getStatus(),path.get(expectedResponse.status+"["+i+"]"));
        }

    }
}
