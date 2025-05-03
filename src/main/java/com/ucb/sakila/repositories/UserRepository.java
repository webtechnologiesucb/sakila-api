package com.ucb.sakila.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ucb.sakila.models.Staff;

public interface UserRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByUsername(String username);
}
