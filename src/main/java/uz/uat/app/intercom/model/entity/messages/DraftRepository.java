package uz.uat.app.intercom.model.entity.messages;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

public interface DraftRepository extends ArangoRepository<Draft, String> {
    @Query(value = "for i in drafts filter i.channel == @channel return i")
    public List<Draft> findByChannel(@Param(value = "channel") String channel);
}
