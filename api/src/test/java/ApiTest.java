import com.jsystems.api.Specificator;
import com.jsystems.api.models.Person;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


public class ApiTest {

    @Test
    @DisplayName("First api REST test")
    public void firstApiTest () {
        RestAssured.given()
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
        RestAssured.given()
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
        JsonPath jsonPath = RestAssured.given()
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

//    @Test
//    @DisplayName("")

}
