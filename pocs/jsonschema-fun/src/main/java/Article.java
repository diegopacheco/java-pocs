import java.awt.geom.Area;
import java.util.Date;
import java.util.UUID;

public class Article {
    private UUID id;
    private String title;
    private String content;
    private Date createdAt;
    private Area area;

    public Article() {}

    public Article(UUID id, String title, String content, Date createdAt, Area area) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.area = area;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", area=" + area +
                '}';
    }
}