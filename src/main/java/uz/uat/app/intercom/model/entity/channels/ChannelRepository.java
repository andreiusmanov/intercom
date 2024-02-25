package uz.uat.app.intercom.model.entity.channels;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

public interface ChannelRepository extends ArangoRepository<Channel, String> {

    @Query(value = "FOR channel IN channels FILTER LENGTH(INTERSECTION(channel.accounts, [@account])) > 0 RETURN channel")
    public List<Channel> findByAccount(@Param(value = "account") String accountId);
}
