package uz.uat.app.intercom.model.entity.channels;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

public interface ChannelRepository extends ArangoRepository<Channel, String> {

    @Query(value = "for i in channels filter i.account == @account return i")
    public List<Channel> findByAccount(@Param(value = "account") String accountId);
}
