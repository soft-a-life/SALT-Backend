package SAL.SALT.Entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Follow {

    @Id @GeneratedValue
    @Column(name = "follow_num")
    private int followNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    @Column(name = "to_user")
    private User user;

    @Column(name = "from_follow")
    private int fromFollow;

    protected Follow() {
    }
}
