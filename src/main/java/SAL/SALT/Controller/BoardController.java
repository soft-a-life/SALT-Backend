package SAL.SALT.Controller;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Entity.Board;
import SAL.SALT.Service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    }

    @GetMapping("/boards/{id}")
    public String searchList(@RequestParam String searchKeyword) {
        boardService.searchList(searchKeyword);
        return "/board";
    }

}
