import java.io.Serializable;

public class Root implements Serializable {

  private static final long serialVersionUID = 1l;
  private Long created = null;

  public Long getCreated() {
    return created;
  }

  public void setCreated(Long created) {
    this.created = created;
  }
  
}