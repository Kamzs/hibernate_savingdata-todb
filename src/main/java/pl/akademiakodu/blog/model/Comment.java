package pl.akademiakodu.blog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @ManyToOne(cascade =CascadeType.ALL)
    private Post post;


}
