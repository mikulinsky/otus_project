package otus.project.notificationService.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import otus.project.notificationService.exception.UserNotFoundException;
import otus.project.notificationService.model.User;
import otus.project.notificationService.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${telegram.bot.name}")
    private String BOT_NAME;

    @Autowired private UserRepository userRepository;

    @PostConstruct
    public void registerBot(){
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        register(update.getMessage());
    }

    public synchronized void sendMsg(String username, String s) {
        User user = userRepository.findUserByUsername(username).orElseThrow(UserNotFoundException::new);
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(user.getChatId());
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            logger.info("Exception: {}", e.toString());
        }
    }

    public synchronized void register(Message message) {
        Long chatId = message.getChatId();
        String username = message.getChat().getUserName();
        User user = userRepository.findUserByUsername(username).orElse(new User(username, -1L));
        if (!user.getChatId().equals(chatId)) {
            user.setChatId(chatId);
            userRepository.save(user);
            logger.info("New user registered");
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }
}