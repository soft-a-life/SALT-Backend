package SAL.SALT.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@ToString
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_num;

    @Setter
    private String category_main;

    @Setter
    private String category_sub;

    protected Category() {}

    private Category(String category_main, String category_sub) {
        this.category_main = category_main;
        this.category_sub = category_sub;
    }

    public static Category of(String category_main, String category_sub) {
        return new Category(category_main, category_sub);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return category_num == category.category_num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_num);
    }
}
