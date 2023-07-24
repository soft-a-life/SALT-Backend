package SAL.SALT.Repository;

import SAL.SALT.Entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepositoryDB implements UserRepository{

    @Override
    public Optional<User> findByUserId(String userId);

    @Override
    public List<User> findAll();
}
