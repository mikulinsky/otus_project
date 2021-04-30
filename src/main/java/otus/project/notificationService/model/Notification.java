package otus.project.notificationService.model;

public class Notification {
    private NotificationSystem system;
    private String receiver;
    private String msg;

    public NotificationSystem getSystem() {
        return system;
    }

    public void setSystem(NotificationSystem system) {
        this.system = system;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
