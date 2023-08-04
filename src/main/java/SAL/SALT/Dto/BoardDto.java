package SAL.SALT.Dto;

import SAL.SALT.Entity.Board;
import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Deprecated
public class BoardDto {
    private Long boardNum;

    private String title;

    private String content;

    private Date boardGenerate;

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
