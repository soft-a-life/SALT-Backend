package SAL.SALT.Controller;


import SAL.SALT.Entity.Board;
import SAL.SALT.Entity.BoardImage;
import SAL.SALT.Entity.Category;
import SAL.SALT.Service.BoardAndImageService;
import SAL.SALT.domain.BoardDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardAndImageService boardAndImageService;

    @PostMapping("/boards")
    public String writeBoard(@Validated BoardDomain boardDomain, BindingResult bindingResult) {
        Category category = new Category(boardDomain.getCategoryMain(), boardDomain.getCategorySub());
        boardAndImageService.saveCategory(category);
        Board board = new Board(boardDomain.getTitle(), boardDomain.getContent(), boardDomain.getBoardGenerate(), category);
        boardAndImageService.save(board);
        BoardImage boardImage = new BoardImage(board, boardDomain.getBoardImagePath());
        boardAndImageService.saveImage(boardImage);
        return "ok";
    }

}
