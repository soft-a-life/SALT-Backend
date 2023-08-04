package SAL.SALT.Service;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Entity.Board;
import SAL.SALT.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto boardDto) {
        Board board = Board.toSaveEntity(boardDto);
        boardRepository.save(board);
    }


}
