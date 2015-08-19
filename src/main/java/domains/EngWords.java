package domains;

import javax.persistence.*;

@Entity
@Table(name="engwords")
public class EngWords {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="engword")
    private String engword;
    @Column(name="rusWord")
    private String rusword;
    @Column(name="category")
    private String category;
    @Column(name="topic")
    private String topic;
    
    public EngWords(){
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEngword() {
        return engword;
    }
    public void setEngword(String engword) {
        this.engword = engword;
    }
    public String getRusword() {
        return rusword;
    }
    public void setRusword(String rusword) {
        this.rusword = rusword;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
