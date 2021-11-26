import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetBook {

    public static void main(String[] args) {
        // write your code here

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .param("ID", "777777777777")
        .when().get("/Library/GetBook.php")
        .then().log().all().assertThat()
                .statusCode(200)
                .body("book_name", contains("RestAssured"))
                .body("isbn", contains("777777"))
                .body("aisle", contains("777777"))
                .body("author", contains("isaacstephen"));
    }
}