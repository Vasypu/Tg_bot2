import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ITunceBot extends TelegramLongPollingBot {

    private static final String TOKEN = "1420502780:AAFQyeAdagPYkJWzyHimPDjvrE6ambXzbtg";
    private static final String USERNAME = "ItunceBot";

    public ITunceBot(DefaultBotOptions options) {super(options);}

    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            try {
                execute(new SendMessage(chat_id, "hi " + update.getMessage().getText()));
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }
}
