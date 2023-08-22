package SAL.SALT.Service;


import SAL.SALT.Entity.Board;
import SAL.SALT.Entity.BoardImage;
import SAL.SALT.Entity.Category;
import SAL.SALT.Repository.BoardImageRepository;
import SAL.SALT.Repository.BoardRepository;
import SAL.SALT.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardAndImageService {

    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void saveImage(BoardImage boardImage) {
        boardImageRepository.save(boardImage);
    }

    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findBoard(Long boardId) {
        return boardRepository.findById(boardId);
    }
}
