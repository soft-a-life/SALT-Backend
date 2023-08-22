package SAL.SALT.Service;

import SAL.SALT.Entity.User;
import SAL.SALT.Repository.UserRepository;
import SAL.SALT.Security.JwtTokenProvider;
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
    private final JwtTokenProvider jwtTokenProvider; // JwtTokenProvider 주입

    @ResponseBody
    public String login(@RequestBody @Validated LoginMember loginMember, BindingResult bindingResult) {
        User user = userRepository.findByUserId(loginMember.getUserId());

        if (user == null || !encoder.matches(loginMember.getUserPw(), user.getUserPw())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        // 로그인 성공 시 JWT 토큰 생성
        String jwtToken = jwtTokenProvider.generateToken(String.valueOf(user.getUuid()));

        return jwtToken; // JWT 토큰 반환
    }
}
