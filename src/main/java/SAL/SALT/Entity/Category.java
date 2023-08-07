package SAL.SALT.Entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_num")
    private int categoryNum;

    @Column(name = "category_main")
    private String categoryMain;

    @Column(name = "category_sub")
    private String categorySub;

    protected Category() {
    }
}
