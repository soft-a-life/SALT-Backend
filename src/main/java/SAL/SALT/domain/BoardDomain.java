package SAL.SALT.domain;


import lombok.Data;

import java.util.Date;

@Data
public class BoardDomain {

    private String categoryMain;

    private String categorySub;

    private String title;

    private String content;

    private Date boardGenerate;

    private String boardImagePath;

}
