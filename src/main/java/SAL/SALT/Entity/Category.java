package SAL.SALT.Entity;

import SAL.SALT.Dto.CategoryDto;
import SAL.SALT.domain.RegisterMember;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder(builderMethodName = "builder")
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_num")
    private Long categoryNum;

    @Column(length = 16, name = "category_main")
    private String categoryMain;

    @Column(length = 16, name = "category_sub")
    private String categorySub;

    public static Category toSaveEntity(CategoryDto categoryDto) {
        return Category.builder()
                .categoryNum(categoryDto.getCategoryNum())
                .categoryMain(categoryDto.getCategoryMain())
                .categorySub(categoryDto.getCategorySub())
                .build();
    }

}
