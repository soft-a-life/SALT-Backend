package SAL.SALT.Repository;

import SAL.SALT.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByTitleContaining(String searchKeyword);
}
