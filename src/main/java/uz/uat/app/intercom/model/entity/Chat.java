package uz.uat.app.intercom.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "chats")
public class Chat {
    
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String image;
    private LocalDateTime created;
    private String name;
    private String type;
    private List<Chatter> chatters;
    private List<String> tags;
}
