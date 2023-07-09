package SAL.SALT.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    // 생성자, getter, setter 등 필요한 메서드 추가

    // 기타 로직 및 관계 설정 추가
}


