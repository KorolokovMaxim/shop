package com.korolkov.shop.repository.user;

import com.korolkov.shop.entity.user.User;
import com.korolkov.shop.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    @Query("""
            SELECT u
            FROM user u
            WHERE u.email = :email
            """)
    Optional<User> findUserByEmail(String email);
}
