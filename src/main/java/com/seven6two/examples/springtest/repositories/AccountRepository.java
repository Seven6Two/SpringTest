package com.seven6two.examples.springtest.repositories;

import com.seven6two.examples.springtest.models.Account;
import com.seven6two.examples.springtest.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account save(Account account);
    Account findById(int id);
    List<Account> findAll();

}
