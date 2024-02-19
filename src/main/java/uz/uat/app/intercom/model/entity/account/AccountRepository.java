package uz.uat.app.intercom.model.entity.account;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

public interface AccountRepository extends ArangoRepository<Account, String> {

    @Query(value = "for i in accounts filter i.department == @department return i")
    public List<Account> findByDepartment(@Param(value = "department") String department);

    @Query(value = "for i in accounts filter i.login == @login and i.password == @password return i")
    public Account authenticate(@Param(value = "login") String login, @Param(value = "password") String password);

}
