package SAL.SALT.repository;

import SAL.SALT.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String > {

}
