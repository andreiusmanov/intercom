package uz.uat.app.intercom.model.entity.messages;

import com.arangodb.springframework.annotation.Document;

@Document(collection = "drafts")
public class Draft extends Message {
}
