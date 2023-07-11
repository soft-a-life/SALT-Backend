package SAL.SALT.repository;

import SAL.SALT.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUserId(Long userId);
}
