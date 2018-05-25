import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsystems.api.Specificator;
import com.jsystems.api.models.Person;
import com.jsystems.api.models.TestUserGeneric;
import com.jsystems.api.models.UserDevice;
import com.jsystems.api.models.errorModels.ErrorResponse;
import com.jsystems.api.response.TestResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


public class ApiTest {

    @Test
    @DisplayName("First api REST test")
    public void firstApiTest () {
        given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Second api test")
    public void secondApiTest() {
        given()
                .when()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("[0],imie", is("Piotr"))
                .body("[0].nazwisko", is("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].produce", equalTo("dell")); //forma "device.model" powoduje problemy w javie

    }

    @Test
    @DisplayName("First test with mapped object")
    public void firstMappedObjectTest() {
        JsonPath jsonPath = given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        Person person = jsonPath.getObject("", Person.class);
        System.out.println(person);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));
    }

    @Test
    @DisplayName("Second mapped object")
    public void secondMappedObject() {
        JsonPath jsonPath = RestAssured
            .given()
            .spec(Specificator.requestSpecification)
            .when()
            .get("5a6a58222e0000d0377a7789")
            .then()
            .assertThat()
            .statusCode(200)
            .extract()
            .body()
            .jsonPath();

        jsonPath.prettyPrint(); //uklada strukture w czytelny sposob

        List<UserDevice> userDeviceList = jsonPath.getList("", UserDevice.class);
        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).screenSize==17);
    }

    @Test
    @DisplayName("Mapped to Response")
    public void responseTest() {
        Response response = RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("5a6b69ec3100009d211b8aeb")
                .andReturn();

        Person person = response
                .then()
                .extract()
                .body()
                .as(Person.class);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));
        assertTrue(response.contentType().equals("application/json"));
    }

    @Test
    @DisplayName("Mapped list to Response")
    public void responseToList() {
        Response response = RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("5a6a58222e0000d0377a7789")
                .andReturn();

        UserDevice[] userDevices = response
                .then()
                .extract()
                .body()
                .as(UserDevice[].class);

        List<UserDevice> userDeviceList = Arrays.asList(userDevices);
        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).screenSize==17);
        assertTrue(response.contentType().equals("application/json"));
        assertTrue(response.getStatusCode()==200);

    }

    @Test
    @DisplayName("Test for error response")
    public void errorTest() {
        Response response = TestResponse.responseWithListByUrl("5a690b452e000054007a73cd");

        ErrorResponse errorResponse = response
                .then()
                .extract()
                .body()
                .as(ErrorResponse.class);

        assertTrue(errorResponse.Error.errorCode ==400);
        assertTrue(errorResponse.Error.message.equals("your email is invalid"));
        assertTrue(errorResponse.Error.validationError.equals("invalid_email"));
        assertTrue(response.contentType().equals("application/json"));
        assertTrue(response.getStatusCode()==400);

    }

    @Test
    @DisplayName("Post test")
    public void postTest() {
        Person person = new Person("Rafal", "Wrobel");

        Response response = TestResponse.responsePost("5a690a1b2e000051007a73cb", person);

        String responsePost = Arrays.asList(response
                .then()
                .extract()
                .body()
                .as(String[].class)).toString();

        assertTrue(responsePost.equals("[]"));
        assertTrue(response.getStatusCode()==201);
    }

    @Test
    @DisplayName("Test of generic user")
    public void genericTypeTest() throws IOException {

        Response response = TestResponse.responseWithListByUrl("5b05bf3f3200007100ebfa04");

        ObjectMapper objectMapper = new ObjectMapper();
        TestUserGeneric<Integer> testUserGeneric = objectMapper.readValue(
                response
                .then()
                .extract()
                .body()
                .asInputStream(), new TypeReference<TestUserGeneric<Integer>>(){});

        System.out.println(testUserGeneric);

        assertTrue(testUserGeneric.id==1);
    }
}
