package SAL.SALT.Service;


import SAL.SALT.Entity.Follow;
import SAL.SALT.Repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public void save(Follow follow) {
        followRepository.save(follow);
    }

    public Optional<Follow> findFollow(Long followId) {
        return followRepository.findById(followId);
    }
}
