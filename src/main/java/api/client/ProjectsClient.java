package api.client;

import static io.restassured.RestAssured.given;

import api.base.Client;
import api.projectmodels.AuthorID;
import api.projectmodels.Item;
import api.projectmodels.Project;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.List;

public class ProjectsClient extends Client {

  private static final String PROJECTS = "/Projects/";

  @Step("Создание проекта")
  public ValidatableResponse createNewProject(Project project) {
    return given()
        .spec(getBaseSpec())
        .body(project)
        .when()
        .post(PROJECTS)
        .then();
  }

  @Step("Получить проекты, связанные с конкретным пользователем.")
  public ValidatableResponse getProjectsLinkedToUser(int id) {
    return given()
        .spec(getBaseSpec())
        .when()
        .get(PROJECTS + "user/" + id)
        .then();
  }


  public void addProjectsForTests(int id, List<String> projectForTests) {
    // todo загрузить пользователю нужные проекты
    for (String projectName : projectForTests) {
      Project project = new Project(new AuthorID(id), projectName, new Item[0]);
      createNewProject(project);
    }
  }
}

