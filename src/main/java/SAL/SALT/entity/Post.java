package SAL.SALT.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sub_category_name", referencedColumnName = "sub_category_name"),
            @JoinColumn(name = "main_category_name", referencedColumnName = "main_category_name")
    })
    private SubCategory subCategory;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_contents", nullable = false)
    private String postContents;

    @Column(name = "post_create_day")
    private LocalDateTime postCreateDay;

    @Column(name = "post_viewcount")
    private int postViewCount;

    // 생성자, getter, setter 등 필요한 메서드 추가

    // 기타 로직 및 관계 설정 추가
}
