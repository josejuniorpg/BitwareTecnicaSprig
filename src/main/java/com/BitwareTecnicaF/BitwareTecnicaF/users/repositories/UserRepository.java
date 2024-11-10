package com.BitwareTecnicaF.BitwareTecnicaF.users.repositories;

import com.BitwareTecnicaF.BitwareTecnicaF.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
