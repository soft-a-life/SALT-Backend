package SAL.SALT.Dto;

import SAL.SALT.Entity.Category;
import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Deprecated
public class CategoryDto {
    private Long categoryNum;

    private String categoryMain;

    private String categorySub;

    public CategoryDto toSaveDto(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .categoryNum(categoryNum)
                .categoryMain(categoryMain)
                .categorySub(categorySub)
                .build();
        return categoryDto;
    }
}
