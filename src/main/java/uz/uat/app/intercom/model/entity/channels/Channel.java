package uz.uat.app.intercom.model.entity.channels;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;

import lombok.Data;
import uz.uat.app.intercom.model.entity.account.Account;

@Data
@Document(collection = "channels")
public class Channel {
    @Id
    private String id;
    @ArangoId
    private String arangoId;
    private String image;
    private String name;
    private LocalDate startDate;
    private String status;
    @Ref(lazy = true)
    private List<Account> accounts;
}
