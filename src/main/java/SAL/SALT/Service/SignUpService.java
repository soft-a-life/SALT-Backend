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


    /* SignUp method done with RegisterMember Domain */
    @Transactional
    public String signUp(@RequestBody @Validated RegisterMember registerMember, BindingResult bindingResult) {
        if (userRepository.findByUserId(registerMember.getUserId()).isPresent()) {
            throw new RuntimeException("user already exist.");
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
