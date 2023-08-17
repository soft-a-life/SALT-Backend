package SAL.SALT.Controller;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Entity.Board;
import SAL.SALT.Service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public void save(@RequestBody @Validated String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BoardDto boardDto = objectMapper.readValue(jsonData, BoardDto.class);
            boardService.save(boardDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    public void save(@RequestBody @Valid BoardDto boardDto) {
        boardService.save(boardDto);
    }

    @GetMapping("/boards")
    public ResponseEntity<List<Board>> searchList(@RequestParam String searchKeyword) {
        List<Board> boards = boardService.searchList(searchKeyword);
        return ResponseEntity.ok(boards);
    }

}
