package uz.uat.app.intercom.model.entity.channels;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;

import lombok.Data;
import uz.uat.app.intercom.model.entity.account.Account;
/*
 * Класс предназначен для сохранения записи о последнем использованном канале Пользователя
 */

@Data
@Document(collection = "recent_channels")
public class RecentChannel {
@Id
private String id;
@ArangoId
private String arangoId;
/**
 * Ссылка на объект Пользователя
 */
@Ref(lazy = false)
private Account account;
/*
 * Ссылка на канал 
 */
@Ref(lazy = false)
private Channel channel;

}
