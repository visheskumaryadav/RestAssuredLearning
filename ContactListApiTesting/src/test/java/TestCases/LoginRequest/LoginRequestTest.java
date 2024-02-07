package TestCases.LoginRequest;

import POJOClasses.payload.Login;
import POJOClasses.resources.LoggedInUserData;

import TestDataGeneration.GenerateTestData;
import endPoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.notNullValue;
import static  org.hamcrest.MatcherAssert.*;
import static org.hamcrest.number.OrderingComparison.lessThan;

import org.testng.annotations.*;

public class LoginRequestTest {

    private final GenerateTestData generateTestData;
    public LoginRequestTest(){
        generateTestData = GenerateTestData.setUp();
    }
    @BeforeMethod
    public void setUp(){
       RestAssured.baseURI=generateTestData.getConfigData().getBaseUrl() + EndPoints.login();

    }
    @AfterMethod
    public void tearDown(){
        RestAssured.baseURI=null;

    }
    @DataProvider(name = "validLoginUser")
    public Object[] validLoginUserData(){
        LoggedInUserData loggedInUserData=generateTestData.getLoggedInUser();
        return new Object[]{
                loggedInUserData.getValid()
        };
    }

    @DataProvider(name = "invalidLoginUserData")
    public Object[] invalidLoginUserData(){
        LoggedInUserData loggedInUserData=generateTestData.getLoggedInUser();
        return new Object[] {
                loggedInUserData.getInvalid().toArray()
        };
    }
//    @Test(dataProvider = "validLoginUser")
//    public void test1(Object[] obj){
//        Login requestUser=(Login)obj[0];
//        Response response =RestAssured.given().log().all()
//                .contentType(ContentType.JSON)
//                .body(requestUser)
//                .when().post();
//        performAssertions(response,requestUser);
//
//
//    }

    @Test(dataProvider = "invalidLoginUserData")
    public void test2(Object user){

        System.out.println(user);
    }
    private void performAssertions(Response response,Login requestUser){
          response.then().assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .time(lessThan(5000L))
                    .log().all();

           JsonPath jsonPath=new JsonPath(response.asString());
         assertThat("Token is null ...",jsonPath.get("token"),notNullValue());
         String loggedInUserFName= GenerateTestData.setUp().getConfigData().getFirstName();
         assertThat("fName is not matching",jsonPath.get("user.firstName"),containsStringIgnoringCase(loggedInUserFName));
         String loggedInUserLName=GenerateTestData.setUp().getConfigData().getLastName();
         assertThat("lName is not matching",jsonPath.get("user.lastName"),containsStringIgnoringCase(loggedInUserLName));
         assertThat("Email is not matching",jsonPath.get("user.email"),containsStringIgnoringCase(requestUser.getEmail()));
         if(jsonPath.getString("token").isEmpty()){
             assertThat("token is empty",false);
         }

        }

    }

