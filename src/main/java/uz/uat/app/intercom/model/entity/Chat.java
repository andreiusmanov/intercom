package uz.uat.app.intercom.model.entity;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;

import lombok.Data;

@Data
@Document(collection = "chats")
public class Chat {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    @Ref(lazy = true)
    private Chat chat;
    private Timestamp timestamp;
    private String text;
    private Chatter chatter;
    private List<String> files;
    private List<String> tags;
}
