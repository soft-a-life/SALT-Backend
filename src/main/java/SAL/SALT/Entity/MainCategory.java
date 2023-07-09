package SAL.SALT.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Main Category entity
 */

@Getter  @Setter  @Entity  @Table(name = "Main_Category")
public class MainCategory {
    @Id
    @Column(name = "main_category_name")
    private String mainCategoryName;

    @Column(name = "main_category_explanation")
    private String mainCategoryExplanation;

    public MainCategory() {
        // default constructor
    }

    public MainCategory(String mainCategoryName, String mainCategoryExplanation) {
        this.mainCategoryName = mainCategoryName;
        this.mainCategoryExplanation = mainCategoryExplanation;
    }
}


