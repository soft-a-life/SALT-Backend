package SAL.SALT.Entity;


import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_num")
    private int boardNum;

    private String title;

    @Lob
    private String content;

    @Column(name = "board_generate")
    private Date boardGenerate;

    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_num")
    @Column(name = "category_num")
    private Category categoryNum;

    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    @Column(name = "user_num")
    private User userNum;

    protected Board() {
    }
}
