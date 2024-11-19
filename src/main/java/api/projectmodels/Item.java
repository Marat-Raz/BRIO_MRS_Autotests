package api.projectmodels;

public class Item {

  private int id;
  private String relativePath;
  private int itemType;

  public Item() {
  }

  public Item(int id, String relativePath, int itemType) {
    this.id = id;
    this.relativePath = relativePath;
    this.itemType = itemType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRelativePath() {
    return relativePath;
  }

  public void setRelativePath(String relativePath) {
    this.relativePath = relativePath;
  }

  public int getItemType() {
    return itemType;
  }

  public void setItemType(int itemType) {
    this.itemType = itemType;
  }
}
