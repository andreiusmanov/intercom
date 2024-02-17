package uz.uat.app.intercom.model.entity.account;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "accounts")
public class Account {
@Id
private String id;
@ArangoId
private String arangoId;
private String name;
private String surname;
private String patronymic;
private String position;
private Department department; 
private String login;
private String password;
private String macAddress;

}
