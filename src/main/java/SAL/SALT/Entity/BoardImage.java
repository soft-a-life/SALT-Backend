package SAL.SALT.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardImage {

    @Id
    @GeneratedValue
    @Column(name = "board_image_num")
    private Long boardImageNum;

    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_num")
    private Board boardNum;

    private String boardImagePath;

    public BoardImage(Board boardNum, String boardImagePath) {
        this.boardNum = boardNum;
        this.boardImagePath = boardImagePath;
    }
}
