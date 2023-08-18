package SAL.SALT.Entity;

import SAL.SALT.Dto.BoardDto;
import SAL.SALT.Dto.CategoryDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder(builderMethodName = "builder")
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private Long boardNum;

    @Column(length = 32, name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(updatable = false, name = "board_generate")
    private Date boardGenerate;

    @UpdateTimestamp
    @Column(insertable = false, name = "board_update")
    private Date boardUpdate;

    @ManyToOne
    @JoinColumn(name = "category_num", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryNum;

    @ManyToOne
    @JoinColumn(name = "user_num", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNum;

    // BoardDto -> BoardEntity
    public static Board toSaveEntity(BoardDto boardDto) {
        return Board.builder()
                .boardNum(boardDto.getBoardNum())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .boardGenerate(boardDto.getBoardGenerate())
                .boardUpdate(boardDto.getBoardUpdate())
                .build();
    }

}
