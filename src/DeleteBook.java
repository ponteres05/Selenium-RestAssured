import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBook {

    public static void main(String[] args) {
        // write your code here

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .header("Content-Type", "application/json")
                .body("""
                        {
                          "ID": "777777777777"
                        }""")
        .when().post("/Library/DeleteBook.php")
        .then().log().all().assertThat()
                .statusCode(200)
                .body("msg", equalTo("book is successfully deleted"));
    }
}