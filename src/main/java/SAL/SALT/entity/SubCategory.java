package SAL.SALT.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Sub Category entity
 */

@Getter
@Setter
@Entity
@Table(name = "Sub_Category")
public class SubCategory {
    @Id
    @Column(name = "sub_category_name")
    private String subCategoryName;

    @Id
    @ManyToOne
    @JoinColumn(name = "main_category_name")
    private MainCategory mainCategory;

    @Column(name = "sub_category_explanation")
    private String subCategoryExplanation;

    // 기타 로직 및 관계 설정 추가
}
