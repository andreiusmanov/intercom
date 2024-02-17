package uz.uat.app.intercom.model.entity.messages;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "drafts")
public class Draft extends Message {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
}
