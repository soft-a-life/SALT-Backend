package SAL.SALT.Repository;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Optional<Board> findByTitleContaining(String searchKeyword);
}
