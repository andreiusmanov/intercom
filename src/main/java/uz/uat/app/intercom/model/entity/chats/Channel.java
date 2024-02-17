package uz.uat.app.intercom.model.entity.chats;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "chanels")
public class Channel {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String image;
    private String name;
    private LocalDate startDate;
    private String status;
}
