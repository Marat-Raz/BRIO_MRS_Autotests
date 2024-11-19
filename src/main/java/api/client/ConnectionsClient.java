package api.client;

import static generaldatatests.GeneralDataTests.BRIO_CLOUD_CONNECTION_TYPE;
import static generaldatatests.GeneralDataTests.BRIO_CLOUD_PASSWORD;
import static generaldatatests.GeneralDataTests.BRIO_CLOUD_USERNAME;
import static io.restassured.RestAssured.given;

import api.base.Client;
import api.connections.AuthFieldValues;
import api.connections.Connections;
import api.connections.ConnectionsTypeId;
import api.usermodel.UserId;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class ConnectionsClient extends Client {

  private static final String CONNECTIONS = "/Connections/";

  @Step("Добавление ConnectionInfo для пользователя")
  public ValidatableResponse addConnectionInfoToUser(Connections connections) {
    return given()
        .spec(getBaseSpec())
        .body(connections)
        .when()
        .post(CONNECTIONS)
        .then();
  }

  public void addConnectionInfoToUserAutotests(int id) {
    ConnectionsTypeId connectionsTypeId = new ConnectionsTypeId(BRIO_CLOUD_CONNECTION_TYPE);
    UserId userId = new UserId(id);
    AuthFieldValues authFieldValues = new AuthFieldValues(BRIO_CLOUD_USERNAME, BRIO_CLOUD_PASSWORD);
    Connections connections = new Connections(connectionsTypeId, userId, authFieldValues);
    addConnectionInfoToUser(connections);
  }
}
