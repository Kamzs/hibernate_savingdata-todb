package pl.akademiakodu.blog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "post",cascade =CascadeType.ALL)
    private List<Comment> comments = new
            ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content+"}";
    }
}
