package api.client;

import static io.restassured.RestAssured.given;

import api.base.Client;
import api.usermodel.User;
import api.usermodel.UserGenerator;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class UserClient extends Client {

  private static final String USER = "/Users/";
  private static final User user = UserGenerator.getFixedUserForAutotests();

  @Step("Создание пользователя")
  public ValidatableResponse createUser(User user) {
    return given()
        .spec(getBaseSpec())
        .body(user)
        .when()
        .post(USER)
        .then();
  }

  @Step("Удаление пользователя")
  public ValidatableResponse deleteUser(int userID) {
    return given()
        .spec(getBaseSpec())
        .when()
        .delete(USER + userID)
        .then();
  }

  @Step("Получить пользователя по его ID")
  public ValidatableResponse getUserByLogin(String login) {
    return given()
        .spec(getBaseSpec())
        .when()
        .get(USER + "find?login=" + login)
        .then();
  }

  @Step("Получить пользователя по его логину")
  public ValidatableResponse checkUserExistsByLogin(String login) {
    return given()
        .spec(getBaseSpec())
        .when()
        .get(USER + "exists?login=" + login)
        .then();
  }

  @Step("Получить пользователя по его id")
  public ValidatableResponse getUserById(int id) {
    return given()
        .spec(getBaseSpec())
        .when()
        .get(USER + id)
        .then();
  }

  public ValidatableResponse createBrioCloudUserForAutotests() {
    return given()
        .spec(getBaseSpec())
        .body(user)
        .when()
        .post(USER)
        .then();
  }
}
