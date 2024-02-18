package uz.uat.app.intercom.model.entity.messages;

import com.arangodb.springframework.repository.ArangoRepository;

public interface DraftRepository extends ArangoRepository<Draft, String> {

}
