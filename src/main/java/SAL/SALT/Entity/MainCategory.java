package SAL.SALT.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Main Category entity
 */

@Getter
@Setter
@Entity
@Table(name = "main_category")
public class MainCategory {
    @Id
    @Column(name = "main_category_name", length = 16, nullable = false)
    private Long mainCategoryName;

    public MainCategory() {
    }

    public MainCategory(Long mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }
}


