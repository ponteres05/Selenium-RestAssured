package test.java.com.webshop;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class API {

    @Test(priority = 1)
    public void addBook(){
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

    @Test(priority = 2)
    public void getBook(){
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

    @Test(priority = 3)
    public void deleteBook(){
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
