package uz.uat.app.intercom.model.entity.account;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;

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
    @Ref(lazy = true)
    private Department department;
    private String login;
    private String password;
    private String macAddress;
    private String telephone;
    private String tabel;

    public String fio() {
        return this.surname + StringUtils.capitalize(name).charAt(0) + "."
                + StringUtils.capitalize(patronymic).charAt(0) + ".";
    }

}
