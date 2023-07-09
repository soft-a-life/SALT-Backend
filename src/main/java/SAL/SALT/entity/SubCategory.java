package SAL.SALT.entity;

import javax.persistence.*;

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

    // 생성자, getter, setter 등 필요한 메서드 추가

    // 기타 로직 및 관계 설정 추가
}
