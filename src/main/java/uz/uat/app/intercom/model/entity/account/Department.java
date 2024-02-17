package uz.uat.app.intercom.model.entity.account;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
@Document(collection = "departments")
public class Department {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String name;
    private String shortName;
    private String code;
    

}
