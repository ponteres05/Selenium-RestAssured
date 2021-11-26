import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class AddBook {

    public static void main(String[] args) {
        // write your code here

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .header("Content-Type", "application/json")
                .body("""
                        {
                          "name": "RestAssured",
                          "isbn": "777777",
                          "aisle": "777777",
                          "author": "isaacstephen"
                        }""")
        .when().post("/Library/Addbook.php")
        .then().log().all().assertThat()
                .statusCode(200)
                .body("Msg", equalTo("successfully added"));
    }
}