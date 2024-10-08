package com.vipan.hrms.Repository;

import com.vipan.hrms.Entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);

    Optional<UserInfo> findByName(String username);
}
