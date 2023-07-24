package SAL.SALT.Service;

import SAL.SALT.Dto.UserDto;
import SAL.SALT.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public int join(@Validated , Result UserDto userDto) {
        try {
            userRepository.save(userDto.toEntity());
            return 0;
        } catch(Exception e) {
            log.debug("error", e);
            return -1;
        }
    }
}
