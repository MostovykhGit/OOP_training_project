package springnews.model;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;



    public void setId(long id2) {
        this.id = id2;
    }
    public long getId() {
        return this.id;
    }
    public void setTitle(String title1) {
        this.title = title1;
    }
    public String getTitle() {
        return this.title;
    }

    public void setDescription(String genre1) {
        this.description = genre1;
    }
    public String getDescription() {
        return this.description;
    }

}
