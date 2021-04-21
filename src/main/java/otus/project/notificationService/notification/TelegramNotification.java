package otus.project.notificationService.notification;

import otus.project.notificationService.model.Notification;
import otus.project.notificationService.model.NotificationSystem;

public class TelegramNotification extends NotificationSystems{

    public TelegramNotification() {
        system = NotificationSystem.TELEGRAM;
    }

    @Override
    protected void notifyUser(Notification notification) {
        //TODO(telegram bot)
    }
}
