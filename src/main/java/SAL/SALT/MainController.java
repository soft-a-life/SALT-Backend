package SAL.SALT;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("access")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Notification> fetchData() {
        List<Notification> notifications = new ArrayList<>();

        Notification notification1 = new Notification();
        notification1.setPostNum("000");
        notification1.setCategory("공지");
        notification1.setTitle("스프링에서 반환된 공지 데이터");
        notification1.setUser("SAL");
        notification1.setDate("2023.01.12");
        notification1.setViews(0);

        notifications.add(notification1);

        return notifications;
    }
}
