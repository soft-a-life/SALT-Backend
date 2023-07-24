package SAL.SALT.domain;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


@Data
public class Member {

    private final String userId;

    private final String userPw;

    private final String userName;

    private final String userNickname;

    private final Date userBirth;

    private final String email;

    private final String userPhone;

    private final Date registerDate;

    private final Timestamp updateDate;

    private final String isWithdrawal;

    private final String isAdmin;

}
