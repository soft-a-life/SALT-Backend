package SAL.SALT.Entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_num;

    @Column(nullable = false, length= 32)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_num;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_num;

    // meta data
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime board_generate;

    protected Board() {}

    private Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Board of(String title, String content) {
        return new Board(title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board = (Board) o;
        return board_num == board.board_num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_num);
    }
}
