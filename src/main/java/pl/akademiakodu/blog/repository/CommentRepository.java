package pl.akademiakodu.blog.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.blog.model.Comment;

public interface CommentRepository
extends CrudRepository<Comment,Integer> {
}
