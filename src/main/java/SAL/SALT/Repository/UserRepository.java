package SAL.SALT.Repository;

import SAL.SALT.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String Username);
}
