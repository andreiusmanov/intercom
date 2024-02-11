package uz.uat.app.intercom.model.entity;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "persons")
public class Person extends Chatter{
private String fio;

}
