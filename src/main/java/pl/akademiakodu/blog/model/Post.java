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

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new
            ArrayList<>();


}
