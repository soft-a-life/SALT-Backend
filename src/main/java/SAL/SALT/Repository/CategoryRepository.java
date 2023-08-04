package SAL.SALT.Repository;

import SAL.SALT.Entity.Board;
import SAL.SALT.Entity.Category;
import SAL.SALT.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
