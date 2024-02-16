package uz.uat.app.intercom.controller.repo;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

import uz.uat.app.intercom.model.entity.Chat;

public interface ChatRepository extends ArangoRepository<Chat, String> {

    /*
     * returns chats by type
     */
    @Query(value = "for i in chats filter i.type == @chatType return i")
    public List<Chat> findByType(@Param("chatType") String chatType);
}
