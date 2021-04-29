package otus.project.notificationService.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otus.project.notificationService.model.Notification;
import otus.project.notificationService.model.NotificationSystem;
import otus.project.notificationService.telegram.TelegramBot;

@Service
public class TelegramNotification extends NotificationSystems{

    @Autowired
    private TelegramBot telegramBot;

    public TelegramNotification() {
        system = NotificationSystem.TELEGRAM;
    }

    @Override
    protected void notifyUser(Notification notification) {
        telegramBot.sendMsg(notification.getReceiver(), notification.getMsg());
    }
}
