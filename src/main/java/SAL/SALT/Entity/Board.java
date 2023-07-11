package SAL.SALT.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * Post entity
 */

@Getter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "board_id")
    private int boardId;

    @ManyToOne
    @JoinColumn(name = "main_category_name", nullable = false)
    private MainCategory mainCategory;

    @ManyToOne
    @JoinColumn(name = "sub_category_name", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(name = "board_title", length = 64, nullable = false)
    private String boardTitle;

    @Column(name = "board_content", columnDefinition = "TEXT")
    private String boardContent;

    @Column(name = "board_generate_day")
    private LocalDateTime boardGenerateDay;

    @Column(name = "board_viewcount", nullable = false)
    private Integer boardViewCount;

    public Board() {
    }

    public Board(int boardId) {
        this.boardId = boardId;
    }
}