package uz.uat.app.intercom.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.account.AccountRepository;
import uz.uat.app.intercom.model.entity.account.Department;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepo;

    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    public void deleteAccount(Account account) {
        accountRepo.delete(account);
    }

    public List<Account> findAllAccounts() {
        return StreamSupport.stream(accountRepo.findAll().spliterator(), false).toList();
    }

    public List<Account> findByDepartment(Department department){
        return accountRepo.findByDepartment(department.getArangoId());
    }
   
}
