package SAL.SALT.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_num")
    private Long categoryNum;

    @Column(name = "category_main")
    private String categoryMain;

    @Column(name = "category_sub")
    private String categorySub;
}
