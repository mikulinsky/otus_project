package otus.project.notificationService.notification;

import otus.project.notificationService.model.Notification;
import otus.project.notificationService.model.NotificationSystem;

public class EmailNotification extends NotificationSystems{

    public EmailNotification() {
        system = NotificationSystem.MAIL;
    }

    @Override
    protected void notifyUser(Notification notification) {
        //TODO(отправка по SMTP)
    }
}
