package com.bonappetit.repo;

import com.bonappetit.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserById(long id);
    Set<User> getAllBy();
}
