package otus.project.notificationService.notification;

import otus.project.notificationService.model.Notification;

public class NotificationService {

    public static void notify(Notification notification) {
        NotificationSystems notificationSystems = new EmailNotification();
        notificationSystems.setNext(new TelegramNotification());

        notificationSystems.notify(notification);
    }

}
