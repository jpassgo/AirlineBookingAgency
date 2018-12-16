package com.personal.pascoe.useraccountservice.dao;

import com.personal.pascoe.useraccountservice.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
