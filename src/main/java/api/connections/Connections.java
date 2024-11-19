package api.connections;

import api.usermodel.UserId;

public class Connections {

  private ConnectionsTypeId connectionsTypeId;
  private UserId userId;
  private AuthFieldValues authFieldValues;

  public Connections(ConnectionsTypeId connectionsTypeId, UserId userId,
      AuthFieldValues authFieldValues) {
    this.connectionsTypeId = connectionsTypeId;
    this.userId = userId;
    this.authFieldValues = authFieldValues;
  }

  public Connections() {
  }

  public ConnectionsTypeId getConnectionsTypeId() {
    return connectionsTypeId;
  }

  public void setConnectionsTypeId(ConnectionsTypeId connectionsTypeId) {
    this.connectionsTypeId = connectionsTypeId;
  }

  public UserId getUserId() {
    return userId;
  }

  public void setUserId(UserId userId) {
    this.userId = userId;
  }

  public AuthFieldValues getAuthFieldValues() {
    return authFieldValues;
  }

  public void setAuthFieldValues(AuthFieldValues authFieldValues) {
    this.authFieldValues = authFieldValues;
  }
}
