package SAL.SALT.Repository;

import SAL.SALT.Entity.User;
import SAL.SALT.domain.RegisterMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
