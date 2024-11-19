package api.projectmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Project {

  private AuthorID authorID;
  private String title;

  @JsonInclude(Include.ALWAYS)
  private Item[] items;

  public Project(AuthorID authorID, String title, Item[] items) {
    this.authorID = authorID;
    this.title = title;
    this.items = items;
  }

  public Project() {
  }

  public AuthorID getAuthorID() {
    return authorID;
  }

  public void setAuthorID(AuthorID authorID) {
    this.authorID = authorID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Item[] getItems() {
    return items;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }
}
