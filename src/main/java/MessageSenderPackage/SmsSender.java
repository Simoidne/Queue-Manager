package MessageSenderPackage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Objects;

public class SmsSender {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");


    public static boolean sendMessage(String phoneNumber, String textMsg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+17756307944"), // to
                        new PhoneNumber("+14168200938"), // from
                        textMsg)
                .create();

        System.out.println(message.getStatus());
        return !Objects.equals(message.getStatus().toString(), "failed");
    }
}
