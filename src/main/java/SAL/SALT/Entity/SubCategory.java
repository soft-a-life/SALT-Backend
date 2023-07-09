package SAL.SALT.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Sub Category entity
 */

@Getter  @Setter  @Entity  @Table(name = "Sub_Category")
public class SubCategory {
    @Id @Column(name = "sub_category_name")
    private String subCategoryName;

    @Id @ManyToOne @JoinColumn(name = "main_category_name")
    private MainCategory mainCategory;

    @Column(name = "sub_category_explanation")
    private String subCategoryExplanation;

    public SubCategory() {
        // default constructor
    }

    public SubCategory(String subCategoryName, MainCategory mainCategory, String subCategoryExplanation) {
        this.subCategoryName = subCategoryName;
        this.mainCategory = mainCategory;
        this.subCategoryExplanation = subCategoryExplanation;
    }
}
