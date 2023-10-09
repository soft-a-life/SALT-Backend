package SAL.SALT.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_num")
    private Long boardNum;

    private String title;

    @Lob
    private String content;

    @Column(name = "board_generate")
    private Date boardGenerate;

    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_num")
    private Category categoryNum;

    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    private User userNum;
}
