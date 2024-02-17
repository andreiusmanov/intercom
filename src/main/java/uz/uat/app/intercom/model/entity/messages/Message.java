package uz.uat.app.intercom.model.entity.messages;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.channels.Channel;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String message;
    private Channel chanel;
    private Account account;
    private LocalDateTime created;
    
}
