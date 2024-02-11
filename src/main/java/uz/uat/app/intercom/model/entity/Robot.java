package uz.uat.app.intercom.model.entity;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "robots")
public class Robot extends Chatter {

}
