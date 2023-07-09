package SAL.SALT.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Main Category entity
 */

@Getter
@Setter
@Entity
@Table(name = "Main_Category")
public class MainCategory {
    @Id
    @Column(name = "main_category_name")
    private String mainCategoryName;

    @Column(name = "main_category_explanation")
    private String mainCategoryExplanation;

    // 기타 로직 및 관계 설정 추가
}


