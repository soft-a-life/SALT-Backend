package SAL.SALT.Entity;
import javax.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board_image")
public class BoardImage {
    @Id
    @Column(name = "board_image_no")
    private int boardImageNo;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(name = "board_image_url", length = 128, nullable = false)
    private String boardImageUrl;

    public BoardImage() {
    }

    public BoardImage(int boardImageNo, String boardImageUrl) {
        this.boardImageNo = boardImageNo;
        this.boardImageUrl = boardImageUrl;
    }
}