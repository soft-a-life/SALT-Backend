package SAL.SALT.Dto;

import SAL.SALT.Entity.Board;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Deprecated
public class BoardDto {

    @NotNull
    private Long boardNum;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date boardGenerate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date boardUpdate;

    // BoardEntity -> BoardDto
    public BoardDto toSaveDto(Board board) {
        BoardDto boardDto = BoardDto.builder()
                .boardNum(boardNum)
                .title(title)
                .content(content)
                .boardGenerate(boardGenerate)
                .boardUpdate(boardUpdate)
                .build();
        return boardDto;
    }
}
