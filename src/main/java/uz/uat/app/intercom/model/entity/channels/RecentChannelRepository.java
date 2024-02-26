package uz.uat.app.intercom.model.entity.channels;

import com.arangodb.springframework.repository.ArangoRepository;

public interface RecentChannelRepository extends ArangoRepository<RecentChannel, String> {

}
