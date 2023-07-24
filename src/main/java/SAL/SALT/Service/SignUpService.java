package SAL.SALT.Service;

import SAL.SALT.Entity.User;
import SAL.SALT.Repository.UserRepository;
import SAL.SALT.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SignUpService {

    private final UserRepository userRepository;

    @Autowired
    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User signUp(UserDto userDto) {
        if (userRepository.findByUserId(userDto.getUserId()).isPresent()) {
            throw new RuntimeException("이미 존재하는 유저입니다.");
        }

        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserPw(userDto.getUserPw());

        return userRepository.save(user);
    }
}
