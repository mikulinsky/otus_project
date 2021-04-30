package otus.project.notificationService.kafka;

import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import otus.project.notificationService.model.Notification;
import otus.project.notificationService.notification.NotificationService;

@Service
public class KafkaReceiver {
    private final Gson gson = new Gson();

    @KafkaListener(topics = "notifications")
    public void getMessage(String data) {
        try {
            Notification notification = gson.fromJson(data, Notification.class);
            NotificationService.notify(notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
