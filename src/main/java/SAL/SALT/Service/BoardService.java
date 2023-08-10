package SAL.SALT.Service;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Entity.Board;
import SAL.SALT.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto boardDto) {
        try {
            Board board = Board.toSaveEntity(boardDto);
            boardRepository.save(board);
        } catch (CannotGetJdbcConnectionException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: Could not establish a database connection. Please try again later.");
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while saving the board. Please try again later.");
        }
    }

    @Transactional
    public Optional<Board> search(String searchKeyword) {
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Search keyword cannot be empty.");
        }

        try {
            return boardRepository.findByTitleContaining(searchKeyword);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while searching for boards.");
        }
    }

}
