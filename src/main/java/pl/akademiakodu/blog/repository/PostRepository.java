package pl.akademiakodu.blog.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.blog.model.Post;

public interface PostRepository extends
        CrudRepository<Post,Integer> {
}
