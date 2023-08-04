package SAL.SALT.Controller;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/save")
    public void save(@RequestBody String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BoardDto boardDto = objectMapper.readValue(jsonData, BoardDto.class);
            boardService.save(boardDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
