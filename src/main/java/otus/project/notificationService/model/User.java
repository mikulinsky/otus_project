package otus.project.notificationService.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Column(unique = true)
    private String username;

    private Long chatId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = -1L;

    public User() {
        this.username = "";
        this.chatId = -1L;
    }

    public User(String username, Long chatId) {
        this.username = username;
        this.chatId = chatId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String phoneNumber) {
        this.username = phoneNumber;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
