package SAL.SALT.Service;

import SAL.SALT.Entity.User;
import SAL.SALT.Repository.UserRepository;
import SAL.SALT.domain.LoginMember;
import SAL.SALT.domain.MemberData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @ResponseBody
    public MemberData login(@RequestBody @Validated LoginMember loginMember, BindingResult bindingResult) {
        User user = userRepository.findByUserId(loginMember.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("not exist ID"));

        if (!encoder.matches(loginMember.getUserPw(), user.getUserPw())) {
            throw new IllegalArgumentException("wrong password");
        }

        return new MemberData(user.getUserId(), user.getUserNickname());
    }
}
