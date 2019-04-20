package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPassIdAndDeleteFlag(String passId, Boolean aFalse);
}
