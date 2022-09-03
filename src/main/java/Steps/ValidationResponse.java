package Steps;

import Models.DataItem;
import io.qameta.allure.Step;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class ValidationResponse {

    @Step
    public ValidationResponse checkCode(String  actCode, String expCode) {
      assertEquals(actCode,expCode);

        return this;
    }

    @Step
    public ValidationResponse checkData(List<DataItem>  dataItems, List<DataItem> dataItems2) {
        assertEquals(dataItems.size(),dataItems2.size());

        return this;
    }

    @Step
    public ValidationResponse checkMetaSize(String actMetaSize, String expMetaSize) {
        assertEquals(actMetaSize,expMetaSize);

        return this;
    }

    @Step
    public ValidationResponse checkId(int actId,int Id) {
        assertEquals(actId,Id,"Check Id :");

        return this;
    }

    @Step
    public ValidationResponse checkStatus(String actStatus,String Active) {
        assertEquals(actStatus,Active,"Check Status :");

        return this;
    }

    @Step
    public ValidationResponse checkGender(String actGender,String gender) {
        assertEquals(actGender,gender,"Check Gender :");

        return this;
    }

    @Step
    public ValidationResponse checkName(String Name,String expName) {
        assertEquals(Name,expName,"Check Name :");

        return this;
    }

    @Step
    public ValidationResponse checkEmail(String Email,String expEmail) {
        assertEquals(Email,expEmail,"Check email :");

        return this;
    }


}
