package otus.project.notificationService.notification;

import otus.project.notificationService.model.Notification;
import otus.project.notificationService.model.NotificationSystem;

abstract class NotificationSystems {

    protected NotificationSystem system;
    protected NotificationSystems next;

    public NotificationSystems setNext(NotificationSystems next) {
        this.next = next;
        return next;
    }

    public void notify(Notification notification) {
        if (notification.getSystem() == system)
            notifyUser(notification);

        if (next != null)
            next.notify(notification);
    }

    abstract protected void notifyUser(Notification notification);

}
