package SAL.SALT.Service;

import SAL.SALT.Entity.User;
import SAL.SALT.Repository.UserRepository;
import SAL.SALT.domain.RegisterMember;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    public boolean isUserAlreadyRegistered(String userId) {
        return userRepository.existsByUserId(userId);
    }

    /* SignUp method done with RegisterMember Domain */
    @Transactional
    public String signUp(@RequestBody @Validated RegisterMember registerMember, BindingResult bindingResult) {
        if (isUserAlreadyRegistered(registerMember.getUserId())) {
            throw new RuntimeException("User already exists.");
        }

        User user = User.builder()
                .userId(registerMember.getUserId())
                .userPw(encoder.encode(registerMember.getUserPw()))
                .userName(registerMember.getUserName())
                .email(encoder.encode(registerMember.getEmail()))
                .userPhone(encoder.encode(registerMember.getUserPhone()))
                .userNickname(registerMember.getUserNickname())
                .userBirth(registerMember.getUserBirth())
                .build();

        userRepository.save(user);

        return "sign up success";
    }
}
