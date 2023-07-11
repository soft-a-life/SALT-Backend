package SAL.SALT.Entity;

import javax.persistence.*;
import lombok.Getter;

/**
 * Sub Category entity
 */

@Getter
@Entity
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @Column(name = "sub_category_name", length = 16, nullable = false)
    private String subCategoryName;

    @Id
    @ManyToOne
    @JoinColumn(name = "main_category_name", nullable = false)
    private MainCategory mainCategory;

    public SubCategory() {
        // default constructor
    }

    public SubCategory(String subCategoryName, MainCategory mainCategory) {
        this.subCategoryName = subCategoryName;
        this.mainCategory = mainCategory;
    }
}
