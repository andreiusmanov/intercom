package uz.uat.app.intercom.model.entity;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;

import lombok.Data;

@Data
abstract class Chatter {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String name;
    private String login;
    private String password;
}
